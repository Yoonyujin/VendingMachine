package net.uni;

public class Drink {

	private int number;
	private String name;
	private int quantity;
	private int price;
	
	public Drink(int number, String name, int quantity, int price) {
		this.number = number;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void getInfo() {
		System.out.printf("%s %,d개\n", 
				getName(),
				getQuantity());
	}
	
	@Override
	public String toString() {
		return String.format("%d. %s (%,d개) %,d원", 
				getNumber(),
				getName(),
				getQuantity(),
				getPrice());
	}
	
}
