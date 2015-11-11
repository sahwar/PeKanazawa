package jp.co.pekanazawa.auth.web;

import java.util.Locale;

import jp.co.pekanazawa.auth.domain.AuthService;
import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.web.form.AuthForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utility.MessageUtil;

@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    protected AuthService authService;

    @Autowired
    protected MessageSource messageSource;

    /**
     * ログイン処理<br>
     * ログイン成功した場合、メニュー一覧へ遷移する.<br>
     * ※ObjectにBindしないサンプル<br/>
     * 
     * @param form
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(AuthForm form, Model model, Locale locale) {
        String loginId = form.getLoginId();
        String pass = form.getPass();

        Auth auth = this.authService.login(loginId, pass);
        if (auth != null) {
            // ログインOK
            return "account/show";
        }
        // ログインNG
        model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_LOGIN_ERROR, null, locale));
        return "auth/index";
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("authForm", new AuthForm());
        return "auth/index";
    }
}
