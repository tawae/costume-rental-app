package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class BorrowTicket implements Serializable{
	private int id;
	private Date borrowDate;
	private int depositAmount;
	private Client client;
	private User user;
	private ArrayList<BorrowCostume> borrowCostume;
	
	public BorrowTicket() {
		super();
		borrowCostume = new ArrayList<BorrowCostume>();
	}
	
	public BorrowTicket(Date borrowDate, Client client, User user, ArrayList<BorrowCostume> borrowCostume) {
		super();
		this.borrowDate = borrowDate;
		this.client = client;
		this.user = user;
		this.borrowCostume = borrowCostume;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<BorrowCostume> getBorrowCostume() {
		return borrowCostume;
	}
	public void setBorrowCostume(ArrayList<BorrowCostume> borrowCostume) {
		this.borrowCostume = borrowCostume;
	}
}
