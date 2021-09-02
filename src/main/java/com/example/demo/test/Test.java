package com.example.demo.test;

import java.util.HashMap;

/**
 * @Author: WhaleFall541
 * @Date: 2021/9/2 20:11
 */
public class Test {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key1", "1");
        map.put("map", map);
        String str1 = "aaa";
        str1.intern();
        String str2 = new String("bbb");
        Person p = new Person();
        p.setName(str1);
        Person p1 = new Person();
        p.setName(str2);
        int cnt = 0;
        doIt(map, p, p1, cnt);

        System.out.println(map.get("cnt"));
    }

    private static void doIt(HashMap map, Person p, Person p1, int cnt) {
        map.put("key1", "2");
        p.setName("ccc");
        p1.setName("ccc");
        map = (HashMap) map.get("map");
        if (map != null && cnt < 30) {
            map.put("cnt", ++cnt);
            doIt(map, p, p1, cnt);
        }
    }
}
