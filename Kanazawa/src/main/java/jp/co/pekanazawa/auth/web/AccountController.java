package jp.co.pekanazawa.auth.web;

import java.util.List;

import jp.co.pekanazawa.auth.domain.AccountService;
import jp.co.pekanazawa.auth.domain.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping("auth")
	public String show(Model model) {
		List<Account> accounts = this.accountService.findAll();
		model.addAttribute("accounts", accounts);
		return "account/show";
	}

}
