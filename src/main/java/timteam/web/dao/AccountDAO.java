package timteam.web.dao;

import timteam.web.model.Account;

public interface AccountDAO {
	
	boolean insertAccount(Account param);
	
	boolean checkAccount(Account param);
	
	Account login (Account param);
}
