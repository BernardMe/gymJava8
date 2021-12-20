package org.learnit.effective.compare;

import java.awt.Color;
import java.util.Objects;

/**
 * @name: 测试两个对象是否相等(传递性)处理05
 * @Description: 一个很好的变通方法：“优先使用组合而不是继承”
 * @author :  wangzhuo
 * @Date:  20211208
 */
public class Item10Example05 {

    public static void main(String[] args) {
        Point03 p = new Point03(1, 2);
        ColorPoint03 cp1 = new ColorPoint03(1, 2, Color.RED);
        ColorPoint03 cp2 = new ColorPoint03(1, 2, Color.BLUE);
        // 注意：以下使用asPoint()方法获取Point03对象进行比较
        System.out.println(p.equals(cp1.asPoint())); // true
        System.out.println(cp1.asPoint().equals(p)); // true
        System.out.println(p.equals(cp2.asPoint())); // true
        System.out.println(cp2.asPoint().equals(p)); // true
        System.out.println(cp1.asPoint().equals(cp2.asPoint())); // true
        System.out.println(cp2.asPoint().equals(cp1.asPoint())); // true
        // 优先使用组合_传递性
        System.out.println("优先使用组合_传递性" + p.equals(cp2));
    }
}

class ColorPoint03 {
    private final Point03 point;
    private final Color color;

    public ColorPoint03(int x, int y, Color color) {
        point = new Point03(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point03 asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint03))
            return false;
        ColorPoint03 cp = (ColorPoint03) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

}

// 简单不可变的二维整数类Point03
class Point03 {
    public final int x;
    public final int y;

    public Point03(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point03))
            return false;
        Point03 p = (Point03) o;
        return p.x == x && p.y == y;
    }
}
