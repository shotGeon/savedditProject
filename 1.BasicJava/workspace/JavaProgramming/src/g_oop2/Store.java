package g_oop2;

public class Store {

	public static void main(String[] args) {
		DeskTop d1 = new DeskTop("삼성컴퓨터",10000);
		DeskTop d2 = new DeskTop("LG컴퓨터",10000);
		
		AirCon ac1 = new AirCon("삼성에어컨",20000);
		AirCon ac2 = new AirCon("LG에어컨",20000);
		
		TV tv1 = new TV("삼성 TV",30000);
		TV tv2 = new TV("LG TV",30000);
		
		Customer c = new Customer();
		
		c.buy(d1);
		c.buy(ac2);
		c.buy(tv2);
		c.showItem();
		
		((AirCon)c.item[1]).setTemperature();

	}

}

class Product{
	String name; //이름
	int price; //가격
	
	Product(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	//상품의 정보를 반환하는 메서드
	String getInfo(){
		return name +"(" +price+ "원)";
	}
}

class DeskTop extends Product{
	DeskTop (String name, int price){
		super(name,price);
	}
	void programming(){
		System.out.println("프로그램을 만듭니다.");
	}
	
}
class AirCon extends Product{
	AirCon(String name, int price){
		super(name, price);
	}
	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}
class TV extends Product{
	TV(String name, int price){
		super(name,price);
	}
	void setChannel(){
		System.out.println("채널을 변경합니다.");
	}
}

class Customer{
	int money=100000;
	
	Product[] item = new Product[100];
	
	void buy(Product p){
		if(money < p.price){
			System.out.println("잔돈이 부족하다.");
			return;
		}
		money -=p.price;
		
		for(int i=0; i<item.length; i++){
			if(item[i]==null){
				item[i]=p;
				break;
			}
		}
		System.out.println(p.getInfo()+"를 구매했다.");
	}


void showItem(){
	System.out.println("------------------내정보---------------");
	for(int i=0; i<item.length; i++){
		if(item[i]==null){
			break;
		}else{
			System.out.println(item[i].getInfo());
		}
	}
	System.out.println("===================================");
}

}





























