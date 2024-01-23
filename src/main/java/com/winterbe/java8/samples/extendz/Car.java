package com.winterbe.java8.samples.extendz;

public class Car {
	//属性
	private String  carType;
	private String  carNum;
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}  
	//构造方法
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String carType, String carNum) {
		super();
		this.carType = carType;
		this.carNum = carNum;
	}
	//普通方法
	public  void  start(){
		System.out.println("我是车，我启动........");
	}
	public  void  stop(){
		
		System.out.println("我是车，我停止........");
	}

}
