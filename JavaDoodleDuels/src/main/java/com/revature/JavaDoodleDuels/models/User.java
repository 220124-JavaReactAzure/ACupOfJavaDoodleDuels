package com.revature.JavaDoodleDuels.models;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_info")
public class User{
	
	@Id
	@Column(nullable = false)
	private String username;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name="pass", nullable = false)
	private String password;
	
	@Column(name="account_type", nullable = false)
	private int accountType;   // 1-employee, 2-user
	
	@Column(name="employee_code")
	private String employeeCode;  // this is only used for account type 1-employee, if an account type 2-user is created it defaults to ""
	
	@Column(name="account_number")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long accountNumber;  // this will link accounts to duelers
	
	@Column(name="current_dueler_name")
	private String currentDuelerName;  // name of current dueler to pull from DB for a battle

	public User() {
		super();
	}

	public User(String username, String firstName, String lastName, String email, String password, int accountType,
			String employeeCode, String currentDuelerName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountType = accountType;
		this.employeeCode = employeeCode;
		this.currentDuelerName = currentDuelerName;
	}

	public User(String username, String firstName, String lastName, String email, String password, int accountType,
			String employeeCode, long accountNumber, String currentDuelerName) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountType = accountType;
		this.employeeCode = employeeCode;
		this.accountNumber = accountNumber;
		this.currentDuelerName = currentDuelerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrentDuelerName() {
		return currentDuelerName;
	}

	public void setCurrentDuelerName(String currentDuelerName) {
		this.currentDuelerName = currentDuelerName;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", accountType=" + accountType + ", employeeCode=" + employeeCode
				+ ", accountNumber=" + accountNumber + ", currentDuelerName=" + currentDuelerName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType, currentDuelerName, email, employeeCode, firstName, lastName,
				password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return accountNumber == other.accountNumber && accountType == other.accountType
				&& Objects.equals(currentDuelerName, other.currentDuelerName) && Objects.equals(email, other.email)
				&& Objects.equals(employeeCode, other.employeeCode) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
}
