package com.winterbe.java8.samples.constructor;

public class Person {
	//属性
	String name;
	int    age;
	char   gender;
	//构造方法---无参构造方法
	public Person(){
		
	}
	//有参构造方法
	public Person(String name,int age,char gender){
		 this.name = name;
		 this.age=age;
		 this.gender=gender;
	}
	
//	public Person(String name1,int age1,char gender1){
//		 name=name1;
//		 age=age1;
//		 gender=gender1;
//	}
    
	
	public  void  show(){
		System.out.println("个人信息： 姓名："+name+",年龄："+age+"岁,性别："+gender);
	}
}
