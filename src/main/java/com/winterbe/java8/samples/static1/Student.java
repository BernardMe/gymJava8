package com.winterbe.java8.samples.static1;

public class Student {
	 //属性
	int id;
	String name;
	int age;
	String gender;
	long  tel;
	String school;
	static String address;
	//构造方法
	public Student() {
		
	}
	public Student(int id, String name, int age, String gender, long tel, String school,String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.school = school;
		this.address=address;
	}
	//静态方法
	public static  void  study(){
		int age =10;
		System.out.println("学生正在学习......");
	}
	
	//定义显示的方法
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", tel=" + tel
				+ ", school=" + school + ",address="+address+"]";
	}
	
	
	

}
