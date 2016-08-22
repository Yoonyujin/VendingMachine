package net.uni;

public class Customer {

	private Drink fanta;
	private Drink cola;
	private Drink cider;
	
	private int money;
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Customer() {
		fanta = new Drink(1, "환타", 0, 0);
		cola = new Drink(2, "콜라", 0, 0);
		cider = new Drink(3, "사이다", 0, 0);
	}
	
	public int pay(int money) {
		// 고객이 가진 금액에서 지불할 만큼을 뺀다.
		this.money -= money;
		
		// 지불할 금액을 리턴한다.
		return money;
	}
	
	public void takeRemainMoney(int money) {
		this.money += money;
	}
	
	public void takeDrink(Drink drink) {
		
		String name = drink.getName();
		if ( name.equals("환타") ) {
			this.appendDrink(fanta);
		}
		else if ( name.equals("콜라") ) {
			this.appendDrink(cola);
		}
		else if ( name.equals("사이다") ) {
			this.appendDrink(cider);
		}
		
	}
	
	private void appendDrink(Drink drink) {
		int quantity = drink.getQuantity();
		quantity++;
		drink.setQuantity(quantity);
	}
	
	@Override
	public String toString() {
		System.out.println("====== 구매자 ======");
		fanta.getInfo();
		cola.getInfo();
		cider.getInfo();
		
		System.out.printf("%,d원 있습니다.", money);
		return "";
	}
	
}






