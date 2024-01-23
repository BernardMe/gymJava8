package com.winterbe.java8.samples.polymorphism;

public class Chinese  extends Person{
	
	//属性
	  int     age = 6;
	  String  hire;
	  String  eyes;
	//构造方法
	public Chinese(String name,int age,char gender, String hire, String eyes) {
		super(name,age,gender);
		this.hire = hire;
		this.eyes = eyes;
	}
	public Chinese() {
		super();
	}
	
	public Chinese(String name, int age, char gender) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	}
	//公共的访问方法三
	public String getHire() {
		return hire;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}

	public String getEyes() {
		return eyes;
	}
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}
	//重写方法----父类的war()方法不能满足子类的需求，所以要重写
	public  void  war(){
		System.out.println("中国----KO----小日本");
	}

}
