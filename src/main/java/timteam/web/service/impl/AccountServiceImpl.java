package timteam.web.service.impl;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import timteam.web.dao.AccountDAO;
import timteam.web.model.Account;
import timteam.web.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registAccount(Account param) {
		if (accountDAO.checkPhoneNumber(param.getPhoneNumber()) != null) {
			throw new ValidationException("Phone number already in use");
		}

		if (accountDAO.checkEmail(param.getEmail()) != null) {
			throw new ValidationException("Email already in use");
		}

		accountDAO.insertAccount(param);
	}

	@Override
	public Account login(Account param) {
		Account account = accountDAO.login(param);

		if (account == null) {
			throw new ValidationException("Wrong phone number and password");
		}

		return account;
	}

}
