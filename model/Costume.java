package model;

import java.io.Serializable;

public class Costume implements Serializable{
	private int id;
	private String name;
	private String type;
	private String size;
	private String des;
	private float price;
	private int quantity;
	private User user;
	
	public Costume() {
		super();
	}
	
	public Costume(int id, String name, String type, String size, String des, float price, int quantity, User user) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.price = price;
		this.des = des;
		this.quantity = quantity;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {return size;}
	public void setSize(String size) {this.size = size;}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

	public int getQuantity() { return quantity;}
	public void setQuantity(int quantity) { this.quantity = quantity;}

	public User getUser() { return user;}
	public void setUser(User user) { this.user = user;}
}
