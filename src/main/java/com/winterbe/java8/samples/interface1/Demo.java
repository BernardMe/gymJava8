package com.winterbe.java8.samples.interface1;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		//1.数组
		     Person[] per = {
	    			new Person("马尚雄",22),
					new Person("李嘉康",21),
					new Person("陈中山",23),
					new Person("李士城",21),
					new Person("潘杨",22),
					new Person("杜明",18)
		     };
		//2.排序
		     System.out.println(Arrays.toString(per));
		     Arrays.sort(per);
		     System.out.println(Arrays.toString(per));
	}

}
