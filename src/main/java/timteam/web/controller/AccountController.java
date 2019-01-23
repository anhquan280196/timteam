package timteam.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import timteam.web.model.Account;
import timteam.web.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/")
	public String index() {
		return "pages/index";
	}
	
	@GetMapping(value = "/logined")
	public String logined() {
		return "pages/logined";
	}

	@PostMapping(value = "account/login")
	public String login(@RequestParam(name = "txtPhoneNumber") String phoneNumber,
			@RequestParam(name = "txtPassword") String password) {
		Account account = new Account();
		account.setPhoneNumber(phoneNumber);
		account.setPassword(password);
		
		accountService.login(account);
		
		return "redirect:/logined";
	}

}
