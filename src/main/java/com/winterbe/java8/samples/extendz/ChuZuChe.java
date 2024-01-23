package com.winterbe.java8.samples.extendz;

public class ChuZuChe  extends Car{
	// 属性
	    private  String   company;
		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}
	//构造方法
		public ChuZuChe() {
			super();
		}
		public ChuZuChe(String carType, String carNum,String  company) {
			super(carType, carNum);
			this.company=company;
		}
	    //重写
		public  void  start(){
			System.out.println("乘客您好\n我是景顺出租车公司的，我的车牌是京B123，您要去哪里？");
		}
		public  void  stop(){
			
			System.out.println("目的地已经到了，请您付费下车，欢迎再次乘坐！");
		}
	
}
