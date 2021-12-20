package org.learnit.effective.compare;

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

// 实现了不区分大小写的字符串。字符串? toString 保存，但? equals 比较中被忽略
class CaseInsensitiveString02 {
    private final String s;

    public CaseInsensitiveString02(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Item10Example01中违反对称性，解决这个问题，只需要把企图与 String 互操作的代码从 equals 方法中去掉就可以了
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString02 && ((CaseInsensitiveString02)o).s.equalsIgnoreCase(s);
    }
}