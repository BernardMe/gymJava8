package com.winterbe.java8.samples.polymorphism.polymorphism5;

public class Bacon extends Pizza {
    //属性
	private int  weight;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	//构造方法
	public Bacon() {
		super();
	}
	public Bacon(String name, double price, int size,int weight) {
		super(name, price, size);
		this.weight=weight;
	}
	@Override
	public void show() {
		System.out.println("名称："+getName()+"\n 价格："+getPrice()+"\n 大小："+getSize()+"\n 培根克数："+weight);

	}

	

}
