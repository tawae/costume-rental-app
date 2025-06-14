package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Bill implements Serializable{
	private int id;
	private Date returnDate;
	private int depositReturn;
	private User user;
	private Client client;
	private BorrowTicket borrowTicket;
	private ArrayList<ReturnCostume> returnCostumes;



	public Bill() {
		super();
	}
	
	public Bill(Date returnDate, int depositReturn, User user, Client client, BorrowTicket borrowTicket, ArrayList<ReturnCostume> returnCostumes) {
		super();
		this.returnDate = returnDate;
		this.depositReturn = depositReturn;
		this.user = user;
		this.client = client;
		this.borrowTicket = borrowTicket;
		this.returnCostumes = returnCostumes;
		if(returnCostumes == null) {
			this.returnCostumes = new ArrayList<ReturnCostume>();
		}
		else {
			for(ReturnCostume rc : returnCostumes) {
				this.returnCostumes.add(rc);
			}
		}
	}
	public ArrayList<ReturnCostume> getReturnCostumes() {
		return returnCostumes;
	}
	public void setReturnCostumes(ArrayList<ReturnCostume> returnCostumes) {
		this.returnCostumes = returnCostumes;
	}
	public void addReturnCostume(ReturnCostume returnCostume) {
		if(returnCostumes == null) {}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getReturnDate() { return returnDate; }
	public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

	public int getDepositReturn() { return depositReturn; }
	public void setDepositReturn(int depositReturn) { this.depositReturn = depositReturn; }

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() { return client;}
	public void setClient(Client client) { this.client = client;}

	public BorrowTicket getBorrowTicket() { return borrowTicket;}
	public void setBorrowTicket(BorrowTicket borrowTicket) { this.borrowTicket = borrowTicket;	}

}
