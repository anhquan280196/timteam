package timteam.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import timteam.web.exception.ValidationException;
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

	@PostMapping(value = "/account/login")
	public void login(@RequestParam(name = "txtPhoneNumber") String phoneNumber,
			@RequestParam(name = "txtPassword") String password, HttpServletRequest request,
			HttpServletResponse response) throws ValidationException, IOException {
		Account account = new Account();
		account.setPhoneNumber(phoneNumber);
		account.setPassword(password);
		if (accountService.login(account) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			response.getWriter().write(account.toString());
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping(value = "/account/register")
	public void register(@RequestParam(name = "txtPhoneNumber") String phoneNumber,
			@RequestParam(name = "txtEmail") String email, @RequestParam(name = "txtPassword") String password,
			HttpServletResponse response) throws ValidationException, IOException {
		Account account = new Account();
		account.setPhoneNumber(phoneNumber);
		account.setEmail(email);
		account.setPassword(password);

		accountService.registAccount(account);
		response.getWriter().write(account.toString());
	}

}
