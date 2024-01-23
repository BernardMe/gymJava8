package com.winterbe.java8.samples.polymorphism.polymorphism5;

public abstract class Pizza {
	//属性  名称、价格、大小
    private String name;
    private double  price;
    private int  size;
    //get set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
    //构造方法
    public Pizza() {
		super();
	}
	public Pizza(String name, double price, int size) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}
	 //抽象方法
    public  abstract  void  show();

}
