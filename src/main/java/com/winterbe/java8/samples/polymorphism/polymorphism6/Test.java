package com.winterbe.java8.samples.polymorphism.polymorphism6;

import java.util.Scanner;

/**
 * 2.	编写程序描述影视歌三栖艺人
		需求说明：请使用面向对象的思想，设计自定义类，描述影视歌三梄艺人。
		实现思路及关键代码
		1)	分析影视歌三栖艺人的特性
			a)	可以演电影
			b)	可以演电视剧
			c)	可以唱歌
		2)	定义多个接口描述特性
			a)	演电影的接口-----方法：演电影
			b)	演电视剧的接口-----方法：演电视剧
			c)	唱歌的接口-----方法：唱歌
		3)	定义艺人类实现多个接口

 * @author Administrator
 *
 */
public class Test{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你喜欢的艺人：");
		String name = input.next();
		
		//1.创建对象
		SuperStar ss =null;
		          ss = new SuperStar(name,60,'女');
		//2.调用重写之后的方法
		          
		ss.movie();
		ss.showTV();
		ss.rap();
		
	}

}
