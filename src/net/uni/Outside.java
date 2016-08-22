package net.uni;

import java.util.Scanner;

public class Outside {

	private Customer customer;
	private VendingMachine vendingMachine;

	private Scanner input;
	
	public Outside() {
		input = new Scanner(System.in);
		
		vendingMachine = new VendingMachine();
		customer = new Customer();
		customer.setMoney(5000);
	}
	
	/**
	 * 자판기와 고객의 중개
	 */
	public void mediation() {
		
		int selectedMenuId = 0;
		
		while ( true ) {
			// 돈을 넣고 메뉴를 확인한다.
			this.inputMoneyAndShowMenu();
			
			// 메뉴를 선택한다.
			selectedMenuId = input.nextInt();
			vendingMachine.extractDrink(customer, selectedMenuId);
			
			this.showVendingMachineAndCustomerInfo();
			
			if ( this.isSoldOut() ) {
				break;
			}
		}
	}
	
	private void inputMoneyAndShowMenu() {
		System.out.println("음료 자판기입니다. 금액을 넣어주세요.");
		int money = input.nextInt();
		
		boolean isSuccess = false;
		while ( true ) {
			isSuccess = vendingMachine.receiveMoney(customer, money);
			if ( !isSuccess ) {
				System.out.println("금액을 다시 넣어주세요.");
				money = input.nextInt();
			}
			else {
				break;
			}
		}
	}
	
	private void showVendingMachineAndCustomerInfo() {
		// VendingMachine 의 toString() 참조
		System.out.println(vendingMachine);
		// Customer의 toString() 참조
		System.out.println(customer);
	}
	
	private boolean isSoldOut() {
		boolean isSoldOut = customer.getMoney() <= 0 || vendingMachine.isSoldOut();
		return isSoldOut;
	}
	
	public static void main(String[] args) {
		new Outside().mediation();
	}
	
}











