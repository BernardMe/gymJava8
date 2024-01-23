package com.winterbe.java8.samples.interface1;

import java.util.Arrays;

/**
 * 需求：如何对一个数组中的多个对象按照不同的依据进行排序；
 * 技能：认识Comparable接口---外部比较器
 * 
 * 1.既然要进行比较，必须有规则---创建接口
 * 2.规则创建完毕之后，需要使用此规则的子类遵守
 * 3.创建一个工具类，里面定义一个排序的方法，类似于sort()
 *     Arrays.sort(Object[] obj);
 * 4.在测试类中进行测试
 *
 */
public class Test {
	
	public static void main(String[] args) {
		//1. 创建Student类型的数组，里面存储学生对象
		Student[]  stu = {
			//2.添加学生对象	
				new Student("马尚雄",22),
				new Student("李嘉康",21),
				new Student("陈中山",23),
				new Student("李士城",21),
				new Student("潘杨",22),
				new Student("杜明",18)
		};
		//2.输出排序之前的数组
		System.out.println(Arrays.toString(stu));
		//进行排序
		ArraysUtil.sort(stu);
		
		//输出排序之后的数组
		System.out.println(Arrays.toString(stu));
		
		//汉字在unicode编码表中的位置  0--65535
		System.out.println((int)'李');
		System.out.println((int)'王');
		System.out.println((int)'潘');
		System.out.println((int)'马');
		System.out.println((int)'嘉');
		System.out.println((int)'士');
		
	}

}
