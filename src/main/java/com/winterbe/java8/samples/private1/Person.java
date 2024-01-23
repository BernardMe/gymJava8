package com.winterbe.java8.samples.private1;

public class Person {
	//属性
	private String name;
	private int age;
	private char gender;
	private String address;
	private boolean Marry;
	//构造方法
	public Person(){
		super();//调用父类Object的空参构造方法
	}
	//有参构造方法
	public Person(String name, int age, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	// 公共的访问方式   get  set方法
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isMarry() {
		return Marry;
	}
	public void setMarry(boolean marry) {
		Marry = marry;
	}
	//自我介绍 introduce()方法
	public String introduce(){
		return "个人信息   姓名："+this.getName()+",年龄："+this.age+",性别："+gender+"婚否："+Marry+",家庭住址："+address;
	}
	
	
		
	

}
