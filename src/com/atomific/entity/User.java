package com.atomific.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.atomific.entity.UserCredential;
import com.atomific.entity.Address;

@Entity
public class User {
	@Id
	@SequenceGenerator(name="user_sequence",sequenceName="user_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_sequence")
	@Column(name="employeeId")
	private int userId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	@NotNull
	private UserCredential userCredential;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="contact")
	private long contact;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfBirth")
	private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfRegistration")
	private Date dor;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="maritalStatus")
	private String maritalStatus;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userCredential=" + userCredential + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", dob=" + dob + ", dor=" + dor + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", address=" + address + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Embedded
	private Address address;
	
	
}
