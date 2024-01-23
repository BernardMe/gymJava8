package com.winterbe.java8.samples.method1;
/**
 * 需求： 在main方法当中定义两个int类型变量（局部变量）,再定义一个方法他们的值进行交换swap()
 * 技能： 形参和实参，以及参数的调用。
 * 
 * 形参和实参
 *   定义方法的参数是形式参数
 *      public Test1(String name,int age)
 *      name  age就是形参
 *   调用方法的参数是实在参数
 *      Test1 t1 = new Test1("张三",12);
 *      "张三"   12他们是实参
 *   调用方法时要求参数个数相同，类型兼容
 *      public  void add(double x,int y){}
 *      add(12.12,34)
 *
 *  注意：
 *   1. 方法内不能定义方法，但是呢能调用方法
 *   2.调用方法时，如果方法时静态的，那么被调用的方法也需要是静态的。
 */
public class Test1 {
	
	public static void main(String[] args) {
		//1.在main方法当中定义两个int类型变量
		int num1 = 12;
		int num2 = 21;
		System.out.println("调用换位方法之前的值  num1="+num1+",num2="+num2);
		//2.调用方法--目的：换位
		swap(num1,num2);
		//3.输出结果
		System.out.println("调用换位方法之后的值  num1="+num1+",num2="+num2);
	}
	// 定义方法swap  换位
	public static   void  swap(int x,int y){
		//定义第三方变量
		int temp = 0;
		temp=x;
		x=y;
		y=temp;
	}
}
