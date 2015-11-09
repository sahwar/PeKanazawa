package web.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.spring.jpa.entity.Account;
import web.spring.jpa.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping("show")
	public String show(Model model) {
		List<Account> accounts = this.accountService.findAll();
		model.addAttribute("accounts", accounts);
		return "account/show";
	}
}
