package org.learnit.compare;

import java.util.Objects;

/**
 * @name: 测试两个对象是否相等(对称性)处理02
 * @Description: 符合对称性
 * @author :  wangzhuo
 * @Date:  20211208
 */
public class Item10Example02 {

    public static void main(String[] args) {
        CaseInsensitiveString02 cis = new CaseInsensitiveString02("Polish");
        String s = "polish";

        // 注意：符合对称性
        System.out.println(cis.equals(s)); // false
        System.out.println(s.equals(cis)); // false


        CaseInsensitiveString02 cis2 = new CaseInsensitiveString02("polish");
        System.out.println(cis.equals(cis2)); // true
    }
}

// 瀹炵幇浜嗕笉鍖哄垎澶у皬鍐欑殑瀛楃涓层€傚瓧绗︿覆琚� toString 淇濆瓨锛屼絾鍦� equals 姣旇緝涓蹇界暐
class CaseInsensitiveString02 {
    private final String s;

    public CaseInsensitiveString02(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString02 && ((CaseInsensitiveString02)o).s.equalsIgnoreCase(s);
    }
}