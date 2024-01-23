package com.winterbe.java8.samples.polymorphism.polymorphism4;
/**
 * 1.抽象类的定义
 *     如果一个类使用abstract修饰，则此类必是一个抽象类。
 *     抽象类： 把其他类的共性（属性和方法），单独抽取出来，放到一个类中，此类作为父类。
 *     abstract---- 抽象的  
 * 2.抽象类的特点
 *    2.1 它相当于一个模板，天生来作为父类。
 *    2.2 抽象类必须使用abstract修饰
 *    2.3 抽象类中可以定义属性，普通方法,抽象方法,构造方法,方法的重载，方法的重写
 *        与普通类对比：
 *           1.普通类中不能定义抽象方法，而抽象类中既可以定义普通方法也可以定义抽象方法
 *           2.抽象类不能够直接通过new关键字进行实例化对象，而普通类可以。如果抽象类想创建对象，需要借助子类（对象的向上转型）。
 *    2.4 如果抽象类中存在抽象方法，子类继承抽象父类，则子类必须重写父类中全部的抽象方法。
 *    2.5 抽象类的抽象方法，不能使用private修饰,不能使用final修饰
 *    2.6 抽象类(Animal)的子类(Mammal)，可以是抽象类，可以不重写父类的抽象方法。
 *        问题：何时才能重写他们中的抽象方法呢？如果创建一个普通类(Rabbit)继承了Mammal，之后，不仅仅要重写直接父类的抽象方法，
 *             还需要重写间接父类的抽象方法。
 * 3.总结
 *    3.1 抽象方法和抽象类均必须用abstract来修饰
 *    3.2 抽象方法没有方法体，只需要声明不需实现
 *    3.3 有抽象方法的类只能定义能抽象类
 *        相反抽象类里面的方法不一定全是抽象方法，也可能没有抽象方法
 *    3.4 抽象类可以包含属性、方法、构造方法
 *        与普通类的区别（看笔记）
 *    3.5 抽象类只能用来继承。
 *    3.6 抽象方法必须被子类实现。抽象类的子类必须覆盖所有的抽象方法才能被实例化，否则还是抽象类
 * 
 *
 */
public abstract class Animal extends Object{
	//属性
	 private String name;
	 private int age;
	 private String color;
	 //get set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	//构造方法
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	//定义抽象方法
	public  abstract void eat();
	
	public abstract void display();
	
	 
	

}
