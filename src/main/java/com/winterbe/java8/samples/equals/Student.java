package com.winterbe.java8.samples.equals;

public class Student {
	private String name;
	private int age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public  boolean equals(Object obj){
		//通过地址值进行比较  如果地址值相同则是同一个对象
		if(this==obj){
			return true;
		}
		//如果传进来的是空，空和其他对象都是不相同的
		if(obj==null){
			return false;
		}
		//传进来的对象是否属于Student类的一个对象
		if( obj instanceof Student){
			//对象向下转型
			Student stu = (Student)obj;
			if(this.name.equals(stu.name) && this.age==stu.age){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
