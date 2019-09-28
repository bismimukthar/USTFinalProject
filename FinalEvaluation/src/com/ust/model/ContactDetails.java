package com.ust.model;

public class ContactDetails {
	private int contactid;
	private String name;
	private int vendorId;
	private String dept;
	private String email;
	private String phone;
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ContactDetails(int contactid, String name, int vendorId,
			String dept, String email, String phone) {
		super();
		this.contactid = contactid;
		this.name = name;
		this.vendorId = vendorId;
		this.dept = dept;
		this.email = email;
		this.phone = phone;
	}
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ContactDetails [contactid=" + contactid + ", name=" + name
				+ ", vendorId=" + vendorId + ", dept=" + dept + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	

}
