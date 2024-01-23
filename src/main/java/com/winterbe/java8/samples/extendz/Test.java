package com.winterbe.java8.samples.extendz;

public class Test {
	public static void main(String[] args) {
		Person per = new Person();
		per.setName("张三");
		per.setAge(12);
		
	    Person per2 = new Person("李四",23);
	    String str1=per2.introduce();
	    System.out.println(str1);
	    
	    //子类对象---特点：继承父类的属性和方法    提高代码的重用性
	    Student  stu = new Student();
	    //继承公共的访问方法
	    stu.setName("王五");
	    stu.setAge(22);
	    stu.setSchool("北京西三旗小学");
	    //继承父类的方法
	    String str2=stu.introduce();
	    System.out.println(str2);
	    //本类对象调用本类的方法
	    String str3= stu.display();
	    System.out.println(str3);
	    Student stu2 = new Student("赵六",34,"北京东三旗小学");
	    
	}

}
