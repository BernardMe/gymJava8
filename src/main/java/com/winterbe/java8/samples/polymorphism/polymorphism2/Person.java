package com.winterbe.java8.samples.polymorphism.polymorphism2;

public class Person {
    String name;
    int age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
class  Student extends  Person{
	int id;
	String school;
	
	public Student() {
		super();
	}
	public Student(String name,int age) {
		super(name,age);
		
	}
	public Student(String name,int age,int id, String school) {
		super(name,age);
		this.id = id;
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", school=" + school + "]";
	}
}
