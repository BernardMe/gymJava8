package com.winterbe.java8.samples.method2;
/**
 * 技能： 认识this关键字以及使用this
 * 
 * 1.this的含义
 *    this代表的是当前类对象的引用。
 * 2.作用
 *    2.1 可以代替当前类对象来执行某些操作。
 *    2.2 区分成员变量和局部变量重名的问题
 *    2.3 可以在调用方法时，使用this，当然this可以省略不写。
 * 3.应用在那些地方
 *    3.1 普通方法
 *         特殊： 可以在任意地方（在某一个方法内）
 *    3。2 构造方法
 *         特殊：只能放在第一行。
 * 4.总结
 *    4.1 this代表的是当前类对象的引用       Student stu = new Student();
 *         把所有的this换成stu   不推荐这样写
 *         原因： 1. 在类加载的时候，对象可能还没有创建
 *              2. this在整个类当中都代表的是对象的引用，作用范围比stu的作用范围要大
 *    4.2 在普通方法当中，this可以调用其他的方法，而且this关键字可以省略，同时位置在某一个方法当中任意。
 *    4.3 在构造方法当中，this(name,age,gender)必须放在其他构造方法的首行。
 *        构造方法可以重载的
 *    4.4 如果在构造方法当中，使用了this.school=school; 
 *        在没有形参school的情况下，对成员变量school是不能够赋值。
 *    4.5 this/super 不能够在静态方法当中使用。
 *        原因： 1.this是代表当前类对象
 *             2.static的含义--- 静态的 全局的   ---- 随着类的加载（从.java文件编译成.class文件）优先开辟空间。
 *               此时对象还没有创建，所以不能够使用this
 */
public class Student {
	//成员变量
	String name;
	int age;
	char gender;
	String school;
	
	//构造方法
	public  Student(){
		//super(); // 如果子类想创建无参构造方法，首先看父类是否有无参构造方法。
	}
	public Student(String name,int age,char gender ){
		this.name=name;
		this.age=age;
		this.gender=gender;
	
	}
	public Student(String name,int age,char gender ,String school){
		this(name,age,gender);
		this.school=school;
		
	}
	
	//普通方法
	public  void  show(){
		System.out.println("我是"+name+"，今年"+age+"岁了，性别："+gender+"，来自"+school+"很高兴见到你们！");
	}
	
	public void display(){
		this.show();
		System.out.println("很欢你加入我们！");
		
	}
	public static void main(String[] args) {
		   Student stu = new Student("张三",23,'男',"尚学堂西三旗校区");
		   stu.display();
		   
	}
	

}
