package com.winterbe.java8.samples.super1;

public class Rabbit extends Animal{
	private String name;
	private  String longEar;

	@Override
	public void run() {
		super.run();
		System.out.println("兔子跑的贼快........");
	}

}
