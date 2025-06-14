package model;

import java.io.Serializable;

public class Client implements Serializable{
	private int id;
	private String name;
	private String tel;
	private String mail;

	public Client() {
		super();
	}
	
	public Client(String name, String tel, String mail) {
		super();
		this.name = name;
		this.tel = tel;
		this.mail = mail;
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

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String email) {
		this.mail = mail;
	}
	
	
}
