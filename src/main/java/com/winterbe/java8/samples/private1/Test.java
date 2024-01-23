package com.winterbe.java8.samples.private1;
/**
 * 需求： 定义一个Person类，为Person类对象进行初始值操作。
 * 技能： 封装+private 
 * 
 * 1. private封装
 *    1.1 概念： 把一些属性和方法全部定义在一个类中（高内聚），而且对外只提供某些接口来进行访问，不需要向外界展示更多的细节！
 *    1.2 private----私有的  私有化的      封装的另外一层含义就是：隐藏  
 * 2.特点
 *    2.1 高内聚  低耦合
 *    2.2 提高代码的安全性，已经重用性。
 *      扩展： 父类的属性私有话，子类怎麼继承？父类的方法私有化了，子类还能继承吗？
 * 3.应用场景/地方
 *    3.1  不想对外界展示更多细节时，可以考虑使用封装。
 *    3.2  属性----封装
 *         方法----封装----不推荐经常把方法私有化
 * 4.总结
 *   4.1 只要属性私有化，则在其他类中，不能直接通过对象进行初始化值。
 *   4.2 只要在类中定义了私有属性，一般性都不会再此类中再定义main方法，创建对象调用他们的属性和方法了
 *       原因：封装的属性只能在本类中有效，在本类中怎麼修改值都可以，这样造成代码的不安全性，同时也没体现出封装的优势。
 *   4.3 既然说，封装的属性不能直接调用，那么需要通过一个"桥梁"---- 公共的访问方法  getter setter
 *   4.4 公共的访问方法：
 *          getter ---- 获取信息--- 返回值类型----return  返回值==成员变量  （而且名称也尽量保持一致）
 *          setter ---- 赋值/设置 --- void  --- 方法的形参 （尽量和成员变量保持一致 ） ---方法体重--- 真正的赋值操作   this.age =age;
 *   4.5 对方法的封装，某些方法使用  private修饰，这些方法没有特殊意义了。
 *       原因： 外界无法访问到此私有方法，甚至子类都无法访问，只能是本类中创建main方法，创建对象进行访问。 
 *            一些只用于本类的辅助性方法可以用private， 希望其他类调用的方法用public
 *   4.6 在编写布尔类型的私有变量时，写get方法时，应该是以is开头，而不是get开头。
 *   4.7 封装----体现在哪些方面
 *           1.属性的封装 --- get set方法
 *           2.方法的封装（不推荐使用private）
 *           3.把一些常用的属性和方法，全部定义在一个类中，而且方法之间以及类之间，尽量减少依赖性。
 *       
 */
public class Test {
	public static void main(String[] args) {
		Person per = new Person();
		/**
		 * 发现：属性通过私有化之后，不能直接进行调用以及赋值了。
		per.name="张三";
		per.age=12;
		per.gender='男';
		per.address="北京";
		*/
		//通过公共的访问方法进行调用和赋值
		per.setName("王康成");
		per.setAge(120);
		per.setGender('男');
		per.setMarry(false);
		per.setAddress("河南省三门峡市");
		
		
		System.out.println("个人信息：  姓名："+per.getName()+",年龄："+per.getAge()+",性别："+per.getGender()+"婚否："+per.isMarry()+",地址："+per.getAddress());
		
		
		
		
	}

}