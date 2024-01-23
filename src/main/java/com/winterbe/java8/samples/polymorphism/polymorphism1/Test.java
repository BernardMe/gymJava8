package com.winterbe.java8.samples.polymorphism.polymorphism1;


import com.winterbe.java8.samples.polymorphism.Chinese;

/**
 * 1.有父类，有子类-----实现多态必须有继承关系
 * 2.重写父类的方法----makeSound()方法
 * 3.如果子类重写了父类的方法，最终调用的是子类重写之后的方法
 * 4.传入的参数必须与形参类型相关----可以是本类对象，可以是子类对象，但是不允许是父类对象。
 */
public class Test {
	public static void main(String[] args) {
		//1.创建对象----乐器类的对象
		Instrument  a1 = new Instrument();
		Instrument  a2 = new Erhu();
		Instrument a3 = new Piano();
		Instrument a4 = new Violin();
		Chinese s = new Chinese();
		Object obj = new Object();
		
		//2. 创建乐手类的对象----调用play方法
		Musician  m = new Musician();
		m.play(a1);
		m.play(a2);
//		m.play(s);
//		m.play(obj);
		m.play(a3);
		m.play(a4);
		
	}

}
