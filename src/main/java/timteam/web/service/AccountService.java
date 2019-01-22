package timteam.web.service;

import timteam.web.model.Account;

public interface AccountService {

	void registAccount(Account param);
	
	Account login(Account param);
}
