package com.winterbe.java8.samples.clazz1;

public class Student {
	//成员变量
	int id;
	String name;
	int age;
	Computer comp ;
	
	
	//成员方法
	public  String show(){
		return "学生信息：  学号："+id+"，姓名："+name+"年龄:"+age+"岁，计算机："+comp;
	}
	
	public static void main(String[] args) {
		//局部变量
		String str = new String();
		str = "abc";
		String str2 = new String();
		str2 = "abc";
		
		String str3 ="abc";
		String str4 ="abc";
		
		
		
		Computer c = new Computer();
		c.CPU="AMD";
		//创建对象
		Student stu = new Student();
		stu.name="张三";
		stu.id=123456;
		stu.age=12;
		stu.comp=c;
		
		
		
		//调用对象的方法
		System.out.println(stu.show());
	
	}

}
