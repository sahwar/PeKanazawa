package jp.co.pekanazawa.auth.web;

import java.util.Locale;

import jp.co.pekanazawa.auth.domain.AuthService;
import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.web.form.AuthForm;
import jp.co.pekanazawa.component.login.LoginDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utility.MessageUtil;

@Controller
public class LoginController {
    @Autowired
    protected AuthService authService;
    @Autowired
    protected MessageSource messageSource;
    @Autowired
    protected LoginDto loginDto;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("authForm", new AuthForm());
        return FormConst.LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(AuthForm form, Model model, Locale locale) {
        String loginId = form.getLoginId();
        String pass = form.getPass();

        Auth auth = this.authService.login(loginId, pass);
        if (auth != null) {
            // ログインOK
            this.loginDto.login(auth.getId(), auth.getLoginId());
            return "redirect:" + FormConst.AUTH_LIST;
        }
        // ログインNG
        model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_LOGIN_ERROR, null, locale));
        return FormConst.LOGIN;
    }

}
