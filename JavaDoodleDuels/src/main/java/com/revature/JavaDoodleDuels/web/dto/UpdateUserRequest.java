package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateUserRequest {
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	private String email;
	
	@Size(min=4, max=20)
	private String username;
	
	@Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
			message="Passwords must have a minimum of 8 characters, one number, one letter and one special character")
	private String password;
	
	private String accountNumber; 

	private int accountType;
	
	private String employeeCode;
	
	private String currentDuelerName;
	
	public UpdateUserRequest() {
		super();
	}

	public UpdateUserRequest(@NotBlank String firstName, @NotBlank String lastName, @Email String email,
			@Size(min = 4, max = 20) String username,
			@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Passwords must have a minimum of 8 characters, one number, one letter and one special character") String password,
			String accountNumber, int accountType, String employeeCode, String currentDuelerName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.employeeCode = employeeCode;
		this.currentDuelerName = currentDuelerName;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public String getCurrentDuelerName() {
		return currentDuelerName;
	}

	public void setCurrentDuelerName(String currentDuelerName) {
		this.currentDuelerName = currentDuelerName;
	}

	@Override
	public String toString() {
		return "UpdateUserRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", employeeCode=" + employeeCode + ", currentDuelerName="
				+ currentDuelerName + "]";
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
		UpdateUserRequest other = (UpdateUserRequest) obj;
		return Objects.equals(accountNumber, other.accountNumber) && accountType == other.accountType
				&& Objects.equals(currentDuelerName, other.currentDuelerName) && Objects.equals(email, other.email)
				&& Objects.equals(employeeCode, other.employeeCode) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

}
