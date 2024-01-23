package com.winterbe.java8.samples.polymorphism.polymorphism5;

import java.util.Scanner;

public class PizzaFactory {
	public  void  make(Pizza p) {
		//1. 创建扫描
		Scanner input = new Scanner(System.in);
		//2.菜单
		do{
			System.out.println("请选择想要制作的披萨(1.培根披萨   2.海鲜披萨)");
			int choice = input.nextInt();
			switch(choice){
			    case 1:
				   System.out.println("您选择的是培根披萨");
				   System.out.println("请输入培根克数：");
				   int weight = input.nextInt();
				   System.out.println("请输入披萨的大小：");
				   int size = input.nextInt();
				   System.out.println("请输入披萨价格");
				   double price = input.nextInt();
				   //创建对象
				   p = new Bacon("培根披萨",price,size,weight);
				   p.show();
				   break;
			    case 2:
					   System.out.println();
					   break;
			    default:
			    	System.out.println("输入有误，请重新输入！");
			}
			
		}while(true);
	}
}
