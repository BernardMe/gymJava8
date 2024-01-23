package com.winterbe.java8.samples.polymorphism;

public class Person {
	//属性
	 String name;
	 int  age =20;
	 char gender;
	//公共的方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	//构造方法
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public  void  war(){
		System.out.println("人与人之间的战争......");
	}
	
	//play(Person per)方法
	public  void play(Person per){
		// 在此方法中根据形参的引用调用本类其他的方法
		per.war();
	}

}
