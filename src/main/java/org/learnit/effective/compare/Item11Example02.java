package org.learnit.effective.compare;

import java.util.HashMap;
import java.util.Map;

/**
 * @name: 测试 hashCode的通用约定02
 * @Description: 在重写 equals 方法的时侯，一定要重写 hashcode 方法 (添加了hashCode方法)
 * @author :  wangzhuo
 * @Date:  20211208
 */
public class Item11Example02 {

    public static void main(String[] args) {
        Map<PhoneNumber2, String> m = new HashMap<>();
        m.put(new PhoneNumber2(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber2(707, 867, 5309))); // Jenny
    }
}


final class PhoneNumber2 {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber2(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);

        return (short)val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber2))
            return false;

        PhoneNumber2 pn = (PhoneNumber2)o;

        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    // 鍏稿瀷鐨刪ashCode鏂规硶
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
