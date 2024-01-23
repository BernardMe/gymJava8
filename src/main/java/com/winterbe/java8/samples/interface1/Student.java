package com.winterbe.java8.samples.interface1;

public class Student implements StuComparable {
	//属性----最比较做准备
	private  String name;
	private int age;
	//get set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//构造方法
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//toString方法
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	/**
	 * 指定具体的规则----  优先以年龄进行排序，如果年龄相同，则按照姓名(字符串)排序
	 */
	@Override
	public int comparable(Object obj) {
		//强制转换
		Student stu=(Student) obj;
		if(this.age > stu.age){
			return 1;
			
		}else if(this.age < stu.age){
			return -1;
		}else{
			//return 0;//年龄相同
			return this.name.compareTo(stu.name);
		}
	}
}
