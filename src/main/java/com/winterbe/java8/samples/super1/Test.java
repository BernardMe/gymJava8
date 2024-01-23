package com.winterbe.java8.samples.super1;
/**
 * 技能：认识super关键字
 * 
 * 1.super的含义
 *    super  --- 超级     superstar    superman  在java当中代表的是父类/父类对象的引用。
 * 2.作用
 *   2.1 引用的作用---- 代表的是父类对象的引用。
 *   2.2 this的最大特点：可以区分成员变量和局部变量重名的问题。
 *       super--- 在子类重写父类某个方法之后，如果想调用父类的方法而不是子类重写的，则可以使用super来区分。
 * 
 * 3.总结
 *    3.1 静态方法中不允许有this和super关键字
 *    3.2 super关键字不仅仅可以区分子类重写之后的方法，以及可以区分子类和父类相同的属性。
 *    3.3 在构造方法中，this和super调用构造方法时，不能同时存在首行。
 *          super(name,age); 
 *          this(school,address);
 */
public class Test {
	public static void main(String[] args) {
		//创建对象
		Animal  an = new Animal();
//		an.eat();
//		an.run();
//		an.sleep();
		
		//兔子对象
		Rabbit  r = new Rabbit();
//		r.eat();
//		r.sleep();
		r.run();// 如果子类重写了父类的run方法，那么调用时，执行的是被子类重写之后的。
		
	}

}
