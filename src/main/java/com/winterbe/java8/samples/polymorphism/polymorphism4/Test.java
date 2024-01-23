package com.winterbe.java8.samples.polymorphism.polymorphism4;
/**
 *  问题：既然子类可以继承父类菲斯有的方法以及全部属性，通过多态机制，父类引用接受子类对象，以这种方式来调用方法和属性。
 *       感觉----- 多此一举！
 *       父类---Person  里面存在私有属性： name,age   菲私有的方法：eat  play  introduce
 *       子类---Student 属性： id  school  address  方法： study()   play()
	 *       Person  per = new Student();
	 *       per.getName()    per.eat()  本类引用调用本类的属性和方法
	 *       per.study(); 父类引用不能调用子类特有的方法。
	 *       
	 *       Student stu = new Student();
	 *       stu.eat();   stu.study();
	 *       
 *  普通类作为父类，真实的多态机制的作用没有发挥出来。
 *     特殊的引用数据类型：抽象类     接口
 *
 */
public class Test {
	public static void main(String[] args) {
		Animal a = new Rabbit();
		a.eat();
	}
	

}
