package com.ust.model;

public class VendorDetails {
	private int contactid;
	private String name;
	private int vendorId;
	private String dept;
	private String email;
	private String phone;
    private String vendorName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private int isActive;
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
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public VendorDetails(int contactid, String name, int vendorId, String dept,
			String email, String phone, String vendorName, String address,
			String location, String service, int pincode, int isActive) {
		super();
		this.contactid = contactid;
		this.name = name;
		this.vendorId = vendorId;
		this.dept = dept;
		this.email = email;
		this.phone = phone;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
	}
	public VendorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VendorDetails [contactid=" + contactid + ", name=" + name
				+ ", vendorId=" + vendorId + ", dept=" + dept + ", email="
				+ email + ", phone=" + phone + ", vendorName=" + vendorName
				+ ", address=" + address + ", location=" + location
				+ ", service=" + service + ", pincode=" + pincode
				+ ", isActive=" + isActive + "]";
	}
	
	

}
