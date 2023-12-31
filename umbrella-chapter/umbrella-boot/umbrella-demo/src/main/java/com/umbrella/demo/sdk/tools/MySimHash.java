package com.umbrella.demo.sdk.tools;

import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * 纯数字，纯字母，字母加数字，相似度，重复汉字
 */
public class MySimHash {
    /**
     * 字符串
     */
    private String tokens;
    /**
     * 字符产的hash值
     */
    private BigInteger strSimHash;
    /**
     * 分词后的hash数
     */
    private int hashbits = 64;

//    private StopRecognition filter;


    public MySimHash(String tokens) {
            this.tokens = tokens;
        this.strSimHash = this.simHash();
    }

    private MySimHash(String tokens, int hashbits) {
            this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();

    }

    /**
     * 这个是对整个字符串进行hash计算
     * @return
     */
    private BigInteger simHash() {
        int[] v = new int[this.hashbits];
        TokenizerEngine engine = TokenizerUtil.createEngine();
        Result result = engine.parse(this.tokens);

        //设定超频词汇的界限 ;
        int overCount = 5;
        Map<Word, Integer> wordCount = new HashMap<Word, Integer>();
        while (result.hasNext()){
            Word word = result.next();
            //  过滤超频词
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                if (count > overCount) {
                    continue;
                }
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }

            // 计算hash
            BigInteger t = this.hash(word.getText());
            for (int i = 0; i < this.hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);

                //添加权重(统一设置20,后续可以自行根据词的不同设置权重)
                int weight = 20;
                if (t.and(bitmask).signum() != 0) {
                    // 这里是计算整个文档的所有特征的向量和
                    v[i] += weight;
                } else {
                    v[i] -= weight;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < this.hashbits; i++) {
            if (v[i] >= 0) {
                    fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;
    }


    /**
     * 对单个的分词进行hash计算;
     * @param source
     * @return
     */
    private BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            //当sourece 的长度过短，会导致hash算法失效，因此需要对过短的词补偿
            while (source.length() < 3) {
                    source = source + source.charAt(0);
            }
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(new BigInteger("1"));
            for (char item : sourceArray) {
                    BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                    x = new BigInteger("-2");
            }
            return x;
        }
    }

    /**
     * 计算海明距离,海明距离越小说明越相似;
     * @param other
     * @return
     */
    private int hammingDistance(MySimHash other) {
            BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
            new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);
        int tot = 0;
        while (x.signum() != 0) {
                tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }


    public double getSemblance(MySimHash s2 ){
        double i = (double) this.hammingDistance(s2);
        return i/this.hashbits ;
    }

    public static void main(String[] args) {
        String text1 = "天气非常好";
        String text2 = "天气真不错";
        MySimHash hash1 = new MySimHash(text1, 64);
        MySimHash hash2 = new MySimHash(text2, 64);
        System.out.println(hash1.hammingDistance(hash2) );
        System.out.println(hash1.getSemblance(hash2));
    }
}
