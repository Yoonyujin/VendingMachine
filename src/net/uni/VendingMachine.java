package net.uni;

public class VendingMachine {

	private Drink fanta;
	private Drink cola;
	private Drink cider;
	
	private int preparedMoney;
	
	private int remainMoney; // 고객에게 돌려줄 거스름돈
	private int paidMoney; // 고객이 자판기에 넣은 돈

	public VendingMachine() {
		fanta = new Drink(1, "환타", 10, 1500);
		cola = new Drink(2, "콜라", 10, 1000);
		cider = new Drink(3, "사이다", 10, 900);
		
		preparedMoney = 500000;
	}
	
	/**
	 * 고객에게 돈을 받는다.
	 * 
	 * @param customer : 불특정 고객
	 * @param money : 고객이 낸 돈
	 */
	public boolean receiveMoney(Customer customer, int money) {
		
		paidMoney = customer.pay(money);
		
		if ( paidMoney < 900 ) {
			System.out.println("돈을 너무 적게 넣었습니다.");
			refundMoney(customer, money);
			return false;
		}
		else {
			showMenu();
			return true;
		}
		
	}
	
	/**
	 * 환불
	 * @param customer : 돈을 넣은 고객
	 * @param money : 환불할 금액
	 */
	public void refundMoney(Customer customer, int money) {
		System.out.printf("%,d원을 가져가세요.\n", money);
		customer.takeRemainMoney(money);
		paidMoney = 0;
	}
	
	/**
	 * 구매가능한 상품을 보여준다.
	 */
	public void showMenu() {
		System.out.printf("%,d원으로 구매할 수 있는 상품입니다.\n", paidMoney);
		
		// 환타, 콜라, 사이다를 모두 보여줌.
		if ( paidMoney >= 1500 ) {
			System.out.println(fanta); // Drink 의 toString() 참조
			System.out.println(cola); // Drink 의 toString() 참조
			System.out.println(cider); // Drink 의 toString() 참조
		}
		else if ( paidMoney >= 1000 ) {
			System.out.println(cola); // Drink 의 toString() 참조
			System.out.println(cider); // Drink 의 toString() 참조
		}
		else if ( paidMoney >= 900 ) {
			System.out.println(cider); // Drink 의 toString() 참조
		}
	}
	
	public void extractDrink(Customer customer, int selectedMenuId) {
		
		if ( selectedMenuId == 1 && paidMoney >= 1500 ) {
			Drink fanta = new Drink(1, "환타", 1, 0);
			customer.takeDrink(fanta);
			
			computeRemainMoneyAndPaidMoney(1500);
			extractProcess(this.fanta);
		}
		else if ( selectedMenuId == 2 && paidMoney >= 1000 ) {
			Drink cola = new Drink(2, "콜라", 1, 0);
			customer.takeDrink(cola);
			
			computeRemainMoneyAndPaidMoney(1000);
			extractProcess(this.cola);
		}
		else if ( selectedMenuId == 3 && paidMoney >= 900 ) {
			Drink cider = new Drink(3, "사이다", 1, 0);
			customer.takeDrink(cider);
			
			computeRemainMoneyAndPaidMoney(900);
			extractProcess(this.cider);
		}
		else {
			remainMoney = paidMoney;
			System.out.println("잘못 눌렀습니다.");
		}
		
		refundMoney(customer, remainMoney);
	}
	
	private void computeRemainMoneyAndPaidMoney(int drinkMoney) {
		remainMoney = paidMoney - drinkMoney;
		preparedMoney += (paidMoney - remainMoney);
	}
	
	private void extractProcess(Drink drink) {
		int quantity = drink.getQuantity();
		quantity--;
		drink.setQuantity(quantity);
	}
	
	@Override
	public String toString() {
		System.out.println("====== 판매자 ======");
		fanta.getInfo();
		cola.getInfo();
		cider.getInfo();
		
		System.out.printf("%,d원 있습니다.", preparedMoney);
		return "";
	}
	
	public boolean isSoldOut() {
		int ciderQuantity = cider.getQuantity();
		int colaQuantity = cola.getQuantity();
		int fantaQuantity = fanta.getQuantity();
		
		int totalQuantity = ciderQuantity + colaQuantity + fantaQuantity;
		
		return totalQuantity == 0;
	}
}




