/**
 * 
 */
package com.engineering.www.vo;

import java.util.Date;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
public class UserProfile {

	private String name = null;
	private Date birthday;
	private String gender = null;
	private Long phoneNumber = null;
	private String emailId = null;
	private int pincode ;
	private String place = null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", pincode=" + pincode + ", place=" + place + "]";
	}
	
}