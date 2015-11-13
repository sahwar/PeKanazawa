package jp.co.pekanazawa.auth.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Locale;

import jp.co.pekanazawa.auth.domain.AuthService;
import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.web.form.AuthForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import utility.MessageUtil;
import utility.PageForm;

/**
 * Login処理<tr>
 * TODO 後でsecurityFilterを追加する
 * @author Uto
 *
 */
@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    protected AuthService authService;

    @Autowired
    protected MessageSource messageSource;

    @ModelAttribute
    public AuthForm setUpAuthForm() {
        return new AuthForm();
    }

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
            return "redirect:/auth/list";
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

    @RequestMapping(value = "list", method = GET)
    public String list(@RequestParam(required = false, defaultValue = "1", name = "page") String page,
            @RequestParam(required = false, defaultValue = "asc", name = "sort") String sort,
            Model model) {
        // listを詰め込む
        Page<Auth> pageAuth = this.authService.findList(Integer.valueOf(page) - 1, null, null);
        model.addAttribute("pages", new PageForm<Auth>(pageAuth, "auth/list"));
        return "auth/list";
    }

    @RequestMapping(value = "detail/{id}", method = GET)
    public String detail(@PathVariable("id") String id, Model model, Locale locale) {
        Auth auth = this.authService.findAuth(id);
        if (auth == null) {
            model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_DETAIL_ERROR, null, locale));
        }
        model.addAttribute("auth", auth);
        return "auth/detail";
    }

    @RequestMapping(value = "create", params = "form")
    public String create(AuthForm form, Locale locale) {
        return "auth/create";
    }

    @RequestMapping(value = "create", params = "redo")
    public String createRedo(AuthForm form) {
        return "auth/create";
    }

    @RequestMapping(value = "create", params = "confirm")
    public String createConfirm(AuthForm form, BindingResult result) {
        if (result.hasErrors()) {
            return createRedo(form);
        }
        return "auth/createConfirm";
    }

}
