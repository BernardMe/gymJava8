package org.learnit.essential;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  wangzhuo
 * @Title Name :
 * @Description :
 * @Copyright :
 * @Creation Date:  2020-09-14 9:38
 */
public class MapTest01 {

    public static void main(String[] args) {


        Map<String, Object> map = new HashMap<>();
        map.put("\"_", 1);

        int hash = "\"_".hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        int h = hash ^ (hash >>> 7) ^ (hash >>> 4);
        System.out.println(hash);
        System.out.println(h);

        int a1 = 1;
        a1 ^= (a1 >>> 20) ^ (a1 >>> 12);
        System.out.println(a1);

        System.out.println(System.identityHashCode(hash));
    }
}
