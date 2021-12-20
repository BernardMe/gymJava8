package org.learnit.effective.compare;

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

// 实现了不区分大小写的字符串。字符串? toString 保存，但? equals 比较中被忽略
class CaseInsensitiveString01 {
    private final String s;

    public CaseInsensitiveString01(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // equals 要做到与普通的字符串比较时不区分大小写，其问题在于String类中的equals方法并不知道不区分大小写，因此反过来比较并不成立，违反了对称性
    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString01)
            return s.equalsIgnoreCase(((CaseInsensitiveString01)o).s);
        if (o instanceof String) // 单向的互操作性(One-way interoperability)!
            return s.equalsIgnoreCase((String)o);
        return false;
    }
}