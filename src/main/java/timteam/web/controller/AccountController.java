package timteam.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import timteam.web.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/")
	public String index() {
		return "pages/index";
	}

}
