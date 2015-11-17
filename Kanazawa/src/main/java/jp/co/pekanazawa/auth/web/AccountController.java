package jp.co.pekanazawa.auth.web;

import java.util.List;
import java.util.Locale;

import jp.co.pekanazawa.auth.domain.AccountService;
import jp.co.pekanazawa.auth.domain.model.Account;
import jp.co.pekanazawa.common.util.MessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    protected AccountService accountService;

    @Autowired
    protected MessageSource messageSource;

    @RequestMapping("list")
    public String show(Model model) {
        List<Account> accounts = this.accountService.findAll();
        model.addAttribute("accountList", accounts);
        return "account/list";
    }

    @RequestMapping(value = "detail/{userId}", method = RequestMethod.GET)
    public String detail(@PathVariable("userId") String userId, Model model, Locale locale) {
        Account account = this.accountService.findAccount(userId);
        if (account == null) {
            model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_LOGIN_ERROR, null, locale));
        }
        model.addAttribute("account", account);
        return "account/detail";
    }

}
