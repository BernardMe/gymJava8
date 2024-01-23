package com.winterbe.java8.samples.polymorphism.polymorphism1;
// 小提琴类---子类
public class Violin extends Instrument{

	@Override
	public void makeSound() {
		System.out.println("小提琴发出的声音-----《梁祝》");
	}
    
}
