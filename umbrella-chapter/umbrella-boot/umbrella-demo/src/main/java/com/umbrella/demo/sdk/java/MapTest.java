package com.umbrella.demo.sdk.java;

import org.apache.commons.collections.map.HashedMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, Map<String, List<String>>> cache = new HashedMap();
        Map<String,List<String>> value = new HashMap<>();
        value.put("124", Arrays.asList("a","b","c"));
        cache.put("abc",value);
        // map computeIfAbsent方法的含义是如果key的值存在则取出，不存在则设置为新给定的值
        Map<String, List<String>> map = cache.computeIfAbsent("abc", key -> new HashMap<>());
        System.out.println(map);
    }
}
