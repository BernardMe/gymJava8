package com.winterbe.java8.samples.polymorphism.polymorphism5;
/**
 * 2.	编写程序实现比萨制作。需求说明编写程序，接收用户输入的信息，选择需要制作的比萨。可供选择的比萨有：培根比萨和海鲜比萨。
                    实现思路及关键代码
		1)	分析培根比萨和海鲜比萨
		2)	定义比萨类（抽象类）,作为父类。
		a)	属性：名称、价格、大小
		b)	方法：展示
		3)	定义培根比萨和海鲜比萨继承自比萨类
		4)	定义比萨工厂类，根据输入信息产生具体的比萨对象
 *
 */
public class Test {
	public static void main(String[] args) {
	
		PizzaFactory p = new PizzaFactory();
		//创建
		p.make( new  Bacon());
//		
	}

}
