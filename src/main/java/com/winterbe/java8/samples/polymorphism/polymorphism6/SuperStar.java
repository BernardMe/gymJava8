package com.winterbe.java8.samples.polymorphism.polymorphism6;
//艺人类     属性：名称
public class SuperStar implements Movie,TV,Sing{
	// 定义属性
	private String name;
	private int age;
	private char gender;
	//getset方法
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
	public SuperStar() {
		super();
		
	}
	public SuperStar(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	//toString方法
	@Override
	public String toString() {
		return "SuperStar [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	@Override
	public void rap() {
		System.out.println("我是"+getName()+",我会唱《双节棍》，《超级英雄》");
	}
	@Override
	public void showTV() {
		System.out.println("我是"+getName()+",我会演《三生三世》,《花千骨》");
	}
	@Override
	public void movie() {
		System.out.println("我是"+getName()+",我会演《幸福像花儿一样》，《银河护卫队2》");
	}
}
