package com.winterbe.java8.samples.interface1;

public class ArraysUtil {
	//定义一个排序的方法---sort(Object[] obj)
	
	public static void  sort(Object[] obj){
		Object temp;
		//1.嵌套for循环
		for(int i=0;i<obj.length;i++){
			//内层for循环
			for(int j=0;j<obj.length-1-i;j++){
				StuComparable sc1=(StuComparable) obj[j];
				StuComparable sc2=(StuComparable) obj[j+1];
				//判断
				if(sc1.comparable(sc2) > 0){
					temp=obj[j];
					obj[j]=obj[j+1];
					obj[j+1]=temp;
				}
			}
		}
		
	}

}
