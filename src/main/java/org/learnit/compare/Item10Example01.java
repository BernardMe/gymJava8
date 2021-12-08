package org.learnit.compare;

import java.util.Objects;

/**
 * @name: 测试两个对象是否相等(对称性)处理01
 * @Description: 违反对称性
 * @author :  wangzhuo
 * @Date:  20211208
 */
public class Item10Example01 {

    public static void main(String[] args) {
        CaseInsensitiveString01 cis = new CaseInsensitiveString01("Polish");
        String s = "polish";

        // 注意：违反对称性
        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false


        CaseInsensitiveString01 cis2 = new CaseInsensitiveString01("polish");
        System.out.println(cis.equals(cis2)); // true
    }
}

// 瀹炵幇浜嗕笉鍖哄垎澶у皬鍐欑殑瀛楃涓层€傚瓧绗︿覆琚� toString 淇濆瓨锛屼絾鍦� equals 姣旇緝涓蹇界暐
class CaseInsensitiveString01 {
    private final String s;

    public CaseInsensitiveString01(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString01)
            return s.equalsIgnoreCase(((CaseInsensitiveString01)o).s);
        if (o instanceof String) // One-way interoperability!
            return s.equalsIgnoreCase((String)o);
        return false;
    }
}