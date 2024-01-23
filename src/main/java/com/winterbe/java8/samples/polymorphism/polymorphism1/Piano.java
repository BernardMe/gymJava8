package com.winterbe.java8.samples.polymorphism.polymorphism1;
//钢琴类----子类
public class Piano extends Instrument{

	@Override
	public void makeSound() {
		System.out.println("钢琴发出的声音-----《命运交响曲》");
	}
    
	
}
