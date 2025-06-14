package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class BorrowCostume implements Serializable{
	private int id;
	private int quantity;
	private float saleoff;
	private ArrayList<Costume> costumes;
	
	public BorrowCostume() {
		super();
		costumes = new ArrayList<Costume>();
	}
	
	public BorrowCostume(int quantity, float saleoff, ArrayList<Costume> costumes) {
		super();
		this.quantity = quantity;
		this.saleoff = saleoff;
		this.costumes = costumes;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() { return quantity;	}
	public void setQuantity(int quantity) {this.quantity = quantity;	}

	public float getSaleoff() { return saleoff;	}
	public void setSaleoff(float saleoff) { this.saleoff = saleoff; }

	public ArrayList<Costume> getCostumes() { return costumes; }
	public void setCostumes(ArrayList<Costume> costumes) { this.costumes = costumes; }

}
