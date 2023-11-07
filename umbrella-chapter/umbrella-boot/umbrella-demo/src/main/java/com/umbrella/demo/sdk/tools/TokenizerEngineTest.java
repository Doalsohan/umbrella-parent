package com.umbrella.demo.sdk.tools;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TokenizerEngineTest {


    public static void main(String[] args) {
        TokenizerEngine engine = TokenizerUtil.createEngine();
        //解析文本
//        String text = "攻城狮逆袭单身狗，迎娶白富美，nginx，走上人生巅峰";

        String text = "GoodYesday";

        Result result = engine.parse(text);
        //输出：这 两个 方法 的 区别 在于 返回 值
        String resultStr = IterUtil.join((Iterator<Word>)result, " ");

        System.out.println(resultStr);

        // 动态增加
        CustomDictionary.add("攻城狮");
        // 强行插入
        CustomDictionary.insert("白富美", "nz 1024");
        CustomDictionary.insert("nginx", "nz 1024");
        CustomDictionary.add("Good");
        CustomDictionary.add("Yes");
        CustomDictionary.add("day");
        // 删除词语（注释掉试试）
//        CustomDictionary.remove("攻城狮");
        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
        System.out.println(CustomDictionary.get("单身狗"));


        // AhoCorasickDoubleArrayTrie自动机扫描文本中出现的自定义词语
        final char[] charArray = text.toCharArray();
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
        {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value)
            {
                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
            }
        });

        // 自定义词典在所有分词器中都有效
        System.out.println(HanLP.segment(text));

        Result parse = engine.parse(text);
        parse.forEach(word -> System.out.println(word.getText()));
        System.out.println(chineseRepeat("我我我我我我我哈"));


    }


    public static boolean  chineseRepeat(String string) {
        TokenizerEngine engine = TokenizerUtil.createEngine();
        Result parse1 = engine.parse(string);
        Set<String> set = new HashSet<>();
        parse1.forEach(word -> set.add(word.getText()));
        return set.size() == 1;
    }

}
