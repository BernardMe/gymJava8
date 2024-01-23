package com.winterbe.java8.samples.extendz;

public class Student extends Person {
	//属性--- 父类有的属性，子类不必再定义了
	private String school;
	//get set方法
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	//构造方法
	public Student() { // 子类定义无参构造方法，如果想要执行，要先执行父类的无参构造方法      理论： 先有父类再有子类     
      
	}
	public Student(String name, int age,String school) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.school=school;
		
	}
	//普通方法
	public String display(){
		return  introduce()+"，学校："+school;
	}
	
	
	

}
