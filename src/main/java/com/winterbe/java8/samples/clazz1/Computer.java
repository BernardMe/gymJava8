package com.winterbe.java8.samples.clazz1;
//计算机类：属性包括   鼠标  CPU  键盘    主板  显示器    定义显示的方法
public class Computer {
	// 成员变量
	String CPU;
	String mouse;
	String mainboard;
	String keyboard;
	String monitor;
	
	//成员方法
	public  void   display(){
		System.out.println("计算机信息：   CPU"+CPU+",鼠标："+mouse+"，主板："+mainboard+",键盘："+keyboard+",显示器："+monitor);
	}

}
