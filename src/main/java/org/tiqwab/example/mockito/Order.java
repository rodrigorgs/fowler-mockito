package org.tiqwab.example.mockito;

public class Order {
	private String sku;
	private int qty;
	private boolean isFilled;
	
	public Order(String sku, int qty) {
		this.sku = sku;
		this.qty = qty;
		this.isFilled = false;
	}
	
	public void fill(Warehouse warehouse) {
		int inventory = warehouse.getInventory(this.sku);
		if (this.qty <= inventory) {
			this.isFilled = true;
			warehouse.remove(this.sku, this.qty);
		}
	}

	public String getSku() {
		return sku;
	}

	public int getQty() {
		return qty;
	}

	public boolean isFilled() {
		return isFilled;
	}

	
}
