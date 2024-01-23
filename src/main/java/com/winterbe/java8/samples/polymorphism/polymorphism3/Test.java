package com.winterbe.java8.samples.polymorphism.polymorphism3;
/**
 * 技能： 认识final关键字
 *   
 * 1.含义
 *    final--- 最后的，最终的      终结器
 * 2.可以修饰什么
 *    2.1 final可以修饰变量------ 变量变为常量
 *         例如： final long  ID =  123456789123456789L;
 *              Math.PI    Math.E
 *    2.2 final修饰方法----- 父类中的方法不能被子类重写，但是可以重载
 *         例如： Person类中有一个使用final修饰的introduce()的方法
 *              印证了父类Person的final修饰的方法，子类Student不能重写，但是可以在本类中重载
 *    2.3 final修饰类 ------ 被final修饰的类，不能被继承/不能派生子类  （被阉割的类）
 *          例如： String   Math  System 这些类都是使用final修饰类
 *          发现： 他们不能派生子类，但是他们可以有父类。
 *    2.4 final修饰对象 ----- 对象的地址值不能变，但是对象中的属性值可以改变。
 *          例如： final  Person  per = new Person("张三",12)
 *                      per.name = "李四";
 *               Person per1 = new Person();
 *               per = per1; (不允许)
 * 3.总结
 *    3.1 final可以使用变量，方法，类，对象，修饰他们之后，都会有一定的变化。
 *    3.2 final 和  finally   finallize  相近的词在网上找一些资料。
 *    
 *   
 *   
 * 笔试题：
 *    final finally  finalize三者之间的联系
 *    throws  throw
 *    Collection  Collections
 *
 */
public class Test {

	public static void main(String[] args) {
		//使用final修饰的对象
		final Person  per1 = new Person("张三",12);
		System.out.println(per1.introduce());
		 per1.name="李四";
		System.out.println(per1.introduce());
		
		//创建对象
		Person per2 = new Person();
		per2 = per1;
		
		//创建对象
		Person per3 = new Person();
//		per1 = per3;

	}

}
