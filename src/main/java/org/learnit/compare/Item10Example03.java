package org.learnit.compare;

import java.awt.Color;

/**
 * @Description: 测试两个对象是否相等(传递性)处理03
 * @Project：test
 * @author :  wangzhuo
 * @Date:  20211208
 */
public class Item10Example03 {

    public static void main(String[] args) {
        Point01 p = new Point01(1, 2);
        ColorPoint01 cp = new ColorPoint01(1, 2, Color.RED);
        System.out.println(p.equals(cp)); // true
        System.out.println(cp.equals(p)); // false
    }
}

class ColorPoint01 extends Point01 {
    private final Color color;

    public ColorPoint01(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint01))
            return false;
        return super.equals(o) && ((ColorPoint01) o).color == color;
    }

}

// 绠€鍗曚笉鍙彉鐨勪簩缁存暣鏁扮被鍨� Point01 绫�
class Point01 {
    private final int x;
    private final int y;

    public Point01(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point01))
            return false;
        Point01 p = (Point01) o;
        return p.x == x && p.y == y;
    }
}
