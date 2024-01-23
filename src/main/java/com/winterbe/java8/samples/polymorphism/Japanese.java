package com.winterbe.java8.samples.polymorphism;

public class Japanese extends Chinese{
	
	//属性
	private  String  ugly;
	//方法
	public String getUgly() {
		return ugly;
	}

	public void setUgly(String ugly) {
		this.ugly = ugly;
	}
	//构造方法
	public Japanese() {
		super();
	}
	public Japanese(String name, int age, char gender, String hire, String eyes,String ugly) {
		super(name, age, gender, hire, eyes);
		this.ugly=ugly;
	}
	public Japanese(String name, int age, char gender) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	}
	//重写的方法

	@Override
	public void war() {
		System.out.println("小日本-----被中国KO");
	}
}
