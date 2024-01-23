package com.winterbe.java8.samples.extendz;
/**
 * 2.	请使用面向对象的思想，设计自定义类，描述出租车和家用轿车的信息。
设定
   1)	出租车类:
                         属性包括：车型，车牌，所属出租公司；方法包括：启动，停止
   2)	家用轿车类：
                        属性包括：车型，车牌，车主姓名；方法包括：启动，停止
要求
1)	分析出租车和家用轿车的公共成员，提取出父类—汽车类
2)	利用继承机制，实现出租车类和家用轿车类
3)	编写测试类，分别测试汽车类，出租车类和家用轿车类对象的相关方法
4)	定义名为car的包存放汽车类，出租车类，家用轿车类和测试类
 */
public class Test1 {
	public static void main(String[] args) {
		//创建父类对象
		Car  c1 = new Car("SUV","京A 888888");
		c1.start();
		c1.stop();
		System.out.println("====================================");
		
		//创建子类对象
		FaimlyCar  c3 = new FaimlyCar("大众","京A 666666","高淇");
		c3.start();
		c3.stop();
		System.out.println("====================================");
		
		//创建子类对象
		ChuZuChe  c2 = new ChuZuChe("大众","京A 666666","北京尚学堂");
		c2.start();
		c2.stop();
		
		
		
		
		
	}

}
