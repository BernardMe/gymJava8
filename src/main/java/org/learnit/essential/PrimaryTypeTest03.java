package org.learnit.essential;

/**
 * <pre>
 * int i = 1;
 * i = i++; a 将i的值1放入值栈； b 在局部变量表中把i的值变为2； c 把值栈中i的值1赋值给局部变量表中i的值(把2覆盖掉了)
 *
 * 值栈和局部变量表 测试类.
 *
 *
 * Created by wanghuaikang on 20210421.
 * </pre>
 *
 * @Title  : 面试1
 * @Description :
 * @author :  wangzhuo
 * @Copyright :
 * @Creation Date:  20210411
 */
public class PrimaryTypeTest03 {

    public static void main(String[] args) {
        int i = 1;
        i = i++;

        int j = i++;

        int k = i + ++i * i++;

        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}
