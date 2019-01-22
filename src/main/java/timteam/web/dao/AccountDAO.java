package timteam.web.dao;

import timteam.web.model.Account;

public interface AccountDAO {

	void insertAccount(Account param);

	Account checkPhoneNumber(String phoneNumber);

	Account checkEmail(String email);

	Account login(Account param);
}
