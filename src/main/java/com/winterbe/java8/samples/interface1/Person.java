package com.winterbe.java8.samples.interface1;

public class Person implements Comparable<Person> {
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
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		//toString方法
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
		@Override
		public int compareTo(Person o) {
			//按照年龄大小进行排序，如果相同则并列输出
			//return this.age-o.age;
			//按照姓名进行排序
			//return this.name.compareTo(o.name);
			//优先按照年龄进行比较，如果年龄相同，则按照姓名排序
			if(this.age>o.age){
				return  1;
			}else if(this.age<o.age){
				return -1;
			}else{
				return this.name.compareTo(o.name);
			}
		}
		
}
