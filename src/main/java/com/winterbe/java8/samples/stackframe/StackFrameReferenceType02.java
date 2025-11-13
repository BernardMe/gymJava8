package com.winterbe.java8.samples.stackframe;

/**
 * 引用数据类型栈帧的局部变量数值交换测试02
 *
 * @author wangzhuo
 * @date 20251113
 */
public class StackFrameReferenceType02 {

    public static void main(String[] args) {
        String a = new String("1"), b = new String("2");
        swapString(a, b);
        System.out.println("a=" + a + " , b=" + b);

        StringBuffer stringBuffer1 = new StringBuffer("1"), stringBuffer2 = new StringBuffer("2");
        swapStringBuffer(stringBuffer1, stringBuffer2);
        System.out.println("stringBuffer1=" + stringBuffer1 + " , stringBuffer2=" + stringBuffer2);

        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        swapObject(person1,person2);
        System.out.println("person1=" + person1 + " , person2=" + person2);
    }

    private static void swapString(String s1,String s2){
        String temp = s1;
        s1 = s2;
        s2 = temp;
    }

    private static void swapStringBuffer(StringBuffer s1,StringBuffer s2){
        StringBuffer temp = s1;
        s1 = s2;
        s2 = temp;
    }

    private static void swapObject(Person p1,Person p2){
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }


    static class Person{
        String name;

        public Person(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}