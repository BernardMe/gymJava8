package com.winterbe.java8.samples.polymorphism.polymorphism1;
//乐手类-----和其他类没有继承关系
public class Musician {
	//弹奏乐器
	public  void  play(Instrument i){
		i.makeSound();
	}

}
