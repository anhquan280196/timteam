package timteam.web.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import timteam.web.dao.AccountDAO;
import timteam.web.model.Account;

@Component
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertAccount(Account param) {
		entityManager.persist(param);
	}
	
	@Override
	public Account checkPhoneNumber(String phoneNumber) {
		return entityManager
				.createQuery("SELECT a FROM Account a WHERE a.phoneNumber = :phoneNumber",
						Account.class)
				.setParameter("phoneNumber", phoneNumber)
				.getSingleResult();
	}

	@Override
	public Account checkEmail(String email) {
		return entityManager
				.createQuery("SELECT a FROM Account a WHERE a.email = :email",
						Account.class)
				.setParameter("email", email)
				.getSingleResult();
	}

	@Override
	public Account login(Account param) {
		return entityManager
				.createQuery("SELECT a FROM Account a WHERE a.phoneNumber = :phoneNumber AND a.password = :password",
						Account.class)
				.setParameter("phoneNumber", param.getPhoneNumber())
				.setParameter("password", param.getPassword())
				.getSingleResult();
	}

}
