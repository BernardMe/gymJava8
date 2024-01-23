package com.winterbe.java8.samples.static2;
/**
 * 技能：认识静态代码块+普通代码块 
 * 
 * 理解：执行的先后顺序
 *    静态代码块  > 普通代码块  > 构造方法
 *  
 *   静态代码块+普通代码块----- > 在类加载的过程当中，JVM已经为他们开辟空间，并执行。  
 *   构造方法-----> 只有在使用new关键字创建对象的时候，才会调用此构造方法，因此才会开辟空间并执行。
 *
 */
public class Demo extends Test {
	//静态代码块
	static{
		System.out.println("这是静态代码块.....");
	}
	//普通代码块
	{
		System.out.println("这是普通代码块.....");
	}
	//构造方法
	public  Demo(){
		System.out.println("这是Demo类空参构造方法......");
	}
	public static void main(String[] args) {
		//创建对象
		Demo  d = new Demo();
	}

}
