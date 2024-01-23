package com.winterbe.java8.samples.polymorphism;
/**
 * 技能：认识多态机制
 * 
 * 1.多态的含义
 *    Java语言中的多态值得是对象的多种形态以及方法的多种形态。
 *    方法的多态---- overload  and  override
 *    对象的多态---- 向上转型 ---- 父类的引用指向了子类对象  
 *                       格式：  父类类型  父类引用  = new 子类类型();
 *                       举例：  Person  per  =  new  Student();
 *                         Person类属性   name age  gender
 *                                 方法： eat()  sleep()  play()
 *                         Student类属性  id  school  address
 *                                 方法：  play()  study()  
 *                       
 *           ----- 向下转型 ---- 子类应用指向了父类对象
 *                       格式： 子类类型  子类引用 = (子类类型) 父类引用; ---- 正确的
 *                        举例： Student stu = (Student)per;
 *                            （子类类型  子类引用 = （子类类型） new  父类类型();）---错误的，不要这么写
 *                             Person类属性   name age  gender
 *                                 方法： eat()  sleep()  play()
 *                             Student类属性  id  school  address
 *                                  方法：  play()  study() 
 *                            
 * 2.特点
 *    2.1  满足多态机制的三个条件     有继承关系，方法的重写以及父类引用指向子类对象
 *    2.2  如果要发生对象的多态，则必须先有对象的向上转型，才能有对象的向下转换（先后顺序-----对应现实生活----现有父母再有孩子）
 *    2.3  编译期间不能确定具体的子类，只能在执行期间才能确定。
 *    2.4  子类对象可以为父类实例化对象。  例如： Person per = new Student();
 *    2.5  重点： 有继承关系的类，如果都存在相同的属性，则按照等号左边的优先调用----属性没有多态
 *              如果有相同的方法，说明发生了重写---- 父类引用调用被重写的方法时，优先调用子类重写之后的。
 * 3.应用
 *    3.1 应用在方法内的形参----形参都是父类类型
 *         例如： public  boolean  equals(Object obj)
 *              public  void  animalCry(Animal a)
 * 4.总结
 *     4.1 在Java当中，多态只适用于对象和方法，属性没有多态。属性是直接调用的。
 *     4.2 灵活,机动。
 *     4.3 如果子类重写了父类的某个方法，通过多态的特征（父类类型  父类引用  = new 子类类型();），
 *          父类对象调用本类的被重写的方法时，执行的是子类重写之后的那个方法！
 *     
 *     
 *     
 *  扩展：
 *      基本数据类型的类型转换
 *         自动转换----- 小的自动转换成大的     double  d = 12.12;   int x =10;  d=d+x;   
 *         强制转换----- 大的转换成小的，精度受到了损失，需要强制转换         x=(int)(d+x);
 */
public class Test {
	public static void main(String[] args) {
		//创建对象
		Person per = new Person();    // 规规矩矩的创建Person类对象
		Person per1 = new Chinese();  // 通过对象的多态---对象的向上转型创建Person类对象
		//per1.eyes; //父类不能调用子类的任何独有的属性和方法。
		Person per2 = new Japanese();
		
		//调用方法和属性
		//验证： 调用属性是否使用到了多态     没有用到
		System.out.println(per.age);
		System.out.println(per1.age);// 20 -- 本类的    6 --- 子类的
		//验证：方法 
		per1.war();// 最终执行的是chinese类中的war方法
		per2.war();// 最终执行的是Japanese类中的war方法 
		
		//调用play方法
		per.play(per);
		per1.play(per1);
		per2.play(per2);
		
		
	}

}
