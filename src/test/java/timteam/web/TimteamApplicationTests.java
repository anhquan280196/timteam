package timteam.web;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import timteam.web.dao.AccountDAO;
import timteam.web.model.Account;
import timteam.web.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimteamApplicationTests {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void testLogin() {
		assertNotNull(accountDAO.login(new Account("1", "1", "1", "1")));
	}

//	@Test
//	public void testRegistAccount() {
//		accountService.registAccount(new Account("8", "8", "1", "8"));
//		accountDAO.insertAccount(new Account("8", "8", "8", "8"));
//		assertNotNull(accountService.login(new Account("8", "8", "8", "8")));
//	}

}
