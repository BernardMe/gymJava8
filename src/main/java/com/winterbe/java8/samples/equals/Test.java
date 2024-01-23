package com.winterbe.java8.samples.equals;
/**
 * 技能： "=="与equals之间的区别！
 * 
 *  相同点：
 *    1. 都可以进行判断比较，返回值类型都是boolean，如果为真，返回true，反之返回false
 *    
 *  不同点：
 *     1. "=="属于关系运算符，equals()可以属于方法
 *     2. "=="即可以比较基本数据类型，也可以比较引用数据类型，但是equals()只能比较引用数据类型。
 *     3. "=="如果比较的是基本数据类型，则比较的是数值是否相同，如果是引用数据类型，比较的是地址值是否相等。
 *        "equals()"如果子类没有重写Object类的equals()方法，则默认比较的是地址值是否相同，
 *        如果重写了则比较的是内容是否相同。
 *     
 *   String类
 *      从源码发现，此类已经重写了Object类的equals()方法，所以在写字符串的时候，字符串对象/引用可以直接调用equals()
 *   自定义类Student
 *      没有重写equals()方法，发现，对象之间比较的是地址值。
 */
public class Test {
	public static void main(String[] args) {
		//使用比较运算符==   比较的是基本数据类型
		int x =10;
		int y =20;
		
		System.out.println(x==y); // false
		boolean flag = false;
//		System.out.println(flag==x);
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println("str1==str2 ----->"+(str1==str2)); // false
		String str3 = "abc";
		String str4= "abc";
		System.out.println("str3==str4 ----->"+(str3==str4)); // true
		
		
		//自定义类进行比较
		Student  stu1 = new Student("张三",12);
		Student  stu2 = new Student("张三",12);
		if(stu1.equals(stu2)){
			System.out.println("同一个人");
		}else{
			System.out.println("不是同一个人");
		}
		
		
		//使用字符串对象以及equals方法进行比较
		String str = "hello world!";
		if(str.equalsIgnoreCase("Hello World!")){
			System.out.println("结果为true");
		}else{
			System.out.println("结果为false");
		}
	}

}
