/**
 * 
 */
package com.engineering.www.vo;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
public class DonorDetails {

	private int donorDetailsId;
	private String category;
	private String bloodgroup;
	private int pincode;
	private String place;
	private int userId;
	public int getDonorDetailsId() {
		return donorDetailsId;
	}
	public void setDonorDetailsId(int donorDetailsId) {
		this.donorDetailsId = donorDetailsId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "DonorDetails [donorDetailsId=" + donorDetailsId + ", category=" + category + ", bloodgroup="
				+ bloodgroup + ", pincode=" + pincode + ", place=" + place + ", userId=" + userId + "]";
	}
	
	
	
}
