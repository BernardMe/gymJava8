package com.winterbe.java8.samples.extendz;

public class FaimlyCar extends Car{
	//属性
	  private  String  name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//方法
	public FaimlyCar() {
		super();
	}

	public FaimlyCar(String carType, String carNum,String name) {
		super(carType, carNum);
		this.name =name;
	}
	
	//重写方法
	public  void  start(){
		System.out.println("我是王康，我的汽车我做主！");
	}
	public  void  stop(){
		
		System.out.println("目的地到了，我们去玩吧！");
	}
}
