package com.winterbe.java8.samples.static2;
import  java.util.Scanner;
public class Test {
	 int a ;
	//静态代码块
		static{
			int a = 10;
			double d = 11;
			System.out.println("12345");
		}
		//普通代码块
		{
			System.out.println("这是Test类普通代码块.....");
		}
		//构造方法
		public  Test(){
			System.out.println("这是Test类空参构造方法......");
		}
		
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			// Date类   日期类      java--- Date   数据库 --- Date 
//			
		}
		
		  
}
