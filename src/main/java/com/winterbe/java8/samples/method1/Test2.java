package com.winterbe.java8.samples.method1;

/**
 * 参数传递
 *   基本数据类型的参数传递
 *      无法通过方法调用改变变量的值
 *   引用数据类型的参数传递
 *      可以通过方法调用改变变量的值
 *      
 * 如果想改变变量的值，需要借助引用数据类型。
 *    1. 把局部变量变为成员变量
 *         (在main方法当中定义的两个变量，变为成员变量)
 *
 */

public class Test2 {
	// 成员变量
	 int num1 = 12;
	 int num2 = 21;
	
	
	
	//main方法
	public static void main(String[] args) {
		//创建对象
		Test2 t2 = new Test2();
		System.out.println("调用换位方法之前的值  num1="+t2.num1+",num2="+t2.num2);
		//调用方法
		t2.swap(t2);
		
		System.out.println("调用换位方法之后的值  num1="+t2.num1+",num2="+t2.num2);
	}
	// 定义方法swap  换位
	public void swap(Test2 t2){
		//定义第三方变量
		int temp = 0;
		temp=t2.num1;
		t2.num1=t2.num2;
		t2.num2=temp;
	}

}
