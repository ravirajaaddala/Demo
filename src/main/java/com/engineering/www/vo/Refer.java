/**
 * 
 */
package com.engineering.www.vo;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
public class Refer {
	private String emailId = null;
	private String phoneNumber = null;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Refer [emailId=" + emailId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
