package timteam.web.service;

import timteam.web.exception.ValidationException;
import timteam.web.model.Account;

public interface AccountService {

	void registAccount(Account param) throws ValidationException;
	
	Account login(Account param);
}
