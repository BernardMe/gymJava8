package com.winterbe.java8.samples.polymorphism.polymorphism2;
/**
 * 技能：instanceof关键字的使用
 * 
 * 1.作用
 *    作用： 判断前面的对象/引用是否属于后面的类型的一个对象  而且返回值是布尔值
 *         per  intanceof Person
 *         说明：如果是后面类型的一个对象，则返回true，反之返回false
 * 2.格式
 *     引用/对象   instanceof  引用数据类型
 * 3.总结
 *    3.1 Object是任何类的父类，任何子类对象都是Object类的一个对象。
 *         Object per1 = new Person();
 *    3.2 通过对象的向上转型，per1就是Person类的一个对象/实例
 *         总结： 父类的引用指向了子类对象（堆内存）
 *    3.3 ClassCastException --- 类型转换异常/对象转换异常
 *         原因： 父类对象是通过new 父类类型()创建的，没有通过对象的向上转型，并且直接进行向下转型
 *    3.4 子类对象无论是以何种方式创建，他都属于父类的一个对象/引用/实例
 *    3.5 使用instanceof关键字，需要前面的对象和后面的数据类型有一定的继承关系吗？
 *    3.6 父类对象不能直接给子类对象，应该加一个强制转换    。
 *    
 *
 */
public class Test {
	public static void main(String[] args) {
		//创建父类对象
		Person per1 = new Student("张三",12);
		Person per2 = new Student("李四",13,2017202,"北京市西三旗校区");
		
		//创建子类对象
		Student stu1 = new Student("张三丰",134,2017202,"湖北武当山校区");
		
		Student stu2 = (Student) per1; // 不建议  原因：没有对象的向上转型，直接进行向下转型，会出现类型转换异常。
		Student stu3 = (Student) per2;
		
		
		//使用intanceof关键字来判断前面的引用是否属于后面数据类型的一个对象？
		System.out.println("per1 instanceof Object---->"+(per1 instanceof Object)); // true
		System.out.println("per1 instanceof Person---->"+(per1 instanceof Person)); // true
		
		System.out.println("per2 instanceof Student---->"+(per2 instanceof Student)); // true
		System.out.println("stu1 instanceof Person---->"+(stu1 instanceof Person));   // true
//		System.out.println("stu1 instanceof  System----->"+(stu1 instanceof System));
		
	}

}
