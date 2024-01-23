package com.winterbe.java8.samples.polymorphism.polymorphism6;
/**
 * 技能： 认识接口
 * 
 * 引用数据类型：  class  类     interface  接口     Array  数组
 * 
 * 1.接口的定义
 *     接口就是一组规则/规范，它是有全局常量和公共的抽象方法组成。
 * 
 * 2.特点
 *    2.1 接口的结构： 一部分是全局常量  一部分是抽象方法
 *         发现：1.不能定义变量，不能定义普通方法
 *              2. 全局常量---默认的使用public static  final 修饰，即使不写，也默认是他们修饰。
 *         扩展： JDK1.8以及之后版本，支持接口定义静态方法,但是不推荐
 *    2.2 接口与类有些不同，接口是没有定义构造方法的。
 *    2.3 创建接口对象，需要借助子类完成，但是子类的构造方法只会与父类的构造方法相关，跟接口没有关系。
 *    2.4 接口中的抽象方法----public abstract都可以省略，但是不建议省略public
 *    2.5 接口可以实现多继承，但是java中的类只能实现单继承。
 * 3.抽象类进行比较，两者之间有和区别？
 *     相同点：
 *        1.天生作为父类，都可以做为模板。
 *        2.都可以存在抽象方法，都可以定义规则。
 *        3.都不能使用new关键字实例化对象，都需要借助子类(对象的向上转型)
 *        4.抽象方法都不能使用private修饰，也不能使用final修饰。
 *     不同点：
 *        1.抽象类可以有构造方法，但是接口没有。
 *        2.抽象类既可以定义普通方法也可以定义抽象方法，但是接口定义方法的话，只能是抽象方法。
 *        3.抽象类中的抽象方法必须使用abstract修饰，接口可以省略
 *        4.抽象类中既可以定义变量也可以定义常量，但是接口只能定义全局常量
 *        5.接口中的抽象方法，必须是public修饰，即使省略不写，也是public修饰，抽象类不是。
 *        6.接口可以实现多继承，但是抽象类只能实现多层/多重继承。
 *        
 *
 */
public interface Movie {
	/**
	public static  final int x =10; // 全局常量
	//普通方法
	public void  add(){
		x =20;
	}
	//构造方法
	public Movie(){
		
	}
	*/
	//定义一个抽象方法 
	public void  movie();

}
/**
//父接口
interface  A {
	 public  void  add();
}

interface  B {
	 public  void  add();
}
//子接口
interface C extends A,B{
	 public  void  add();
	 public  void  max();
	
	
}

abstract  class  D implements A,B,C{
	public  void add(){
		
	}

	
}
*/

