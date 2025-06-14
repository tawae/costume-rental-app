package model;

public class CostumeStat extends Costume {
	private int borrowCount;
	private int totalAmount;
	
	public CostumeStat() {
		super();
	}
	
	public CostumeStat(int borrowCount, int totalAmount) {
		super();
		this.borrowCount = borrowCount;
		this.totalAmount = totalAmount;
	}

	public int getBorrowCount() {
		return borrowCount;
	}
	public void setBorrowCount(int borrowCount) {
		this.borrowCount = borrowCount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
