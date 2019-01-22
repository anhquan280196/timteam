package timteam.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String accountId;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Account(String accountId, String phoneNumber, String email, String password) {
		super();
		this.accountId = accountId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	public Account() {
		super();
	}

}
