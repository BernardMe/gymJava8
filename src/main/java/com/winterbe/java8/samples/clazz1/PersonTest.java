package com.winterbe.java8.samples.clazz1;
/**
 * 2.	编写 Java 程序用于显示人的姓名和年龄。定义一个人类Person。
 *      该类中应该有两个属性： 姓名 （name） 和年龄 （age） 。
 *      定义构造方法用来初始化数据成员。再定义显示（display()） 方法将姓名和年龄打印出来。
 *      在 main 方法中创建人类的实例然后将信息显示。
 *      
 *      
 *   扩展：
 *     1. 内存分配图   三部分：栈内存      先进后出的原则  同时只会存放引用以及局部变量    自动释放空间（方法执行完毕之后）
 *                       堆内存     存储的是对象的具体信息（成员变量）  GC会自动检测  自动回收  
 *                       方法区     是从堆内存分化出来的，  有字符串常量池/代码区/静态区等。
 *     2. 成员变量：
 *          2.1  静态成员变量    类变量   原因： 在类加载的时候，就会分配空间 
 *          2.2  非静态成员变量   对象变量/实例变量   原因： 在创建对象的是偶，才会分配空间，没有创建对象，它永远不会再内存当中分配空间。
 *          2.3   （后续讲解this  super关键字的时候还会提到他们。）
 */
public class PersonTest {
	public static void main(String[] args) {
		//局部变量---定义在方法内/语句内/代码块
		int age = 23;
		String name = "李四";
		System.out.println("个人信息： 姓名："+name+",年龄："+age+"岁");
		//创建对象
		Person per = new Person();
		//对象调用属性
		per.name="李续财";
		per.age=23;
		//对象调用方法
		String info=per.display();
		System.out.println(info);
	}
}
class Person{
	 //私有属性---成员变量
	 String name ;
	 int age;
	
	 //构造方法，如果程序员没有定义具体的构造方法，则JVM会默认给一个空参的构造方法，反之，JVM不会再给了！
	public  String display(){
		return "个人信息： 姓名："+name+",年龄："+age+"岁";
	}
}
