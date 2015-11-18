package jp.co.pekanazawa.auth.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Locale;

import jp.co.pekanazawa.auth.domain.AuthService;
import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.web.form.AuthForm;
import jp.co.pekanazawa.common.util.MessageUtil;
import jp.co.pekanazawa.common.util.PageForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
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

    @RequestMapping(value = "delete/{id}", method = GET)
    public String delete(@PathVariable("id") String id, Model model, Locale locale) {
        Auth auth = this.authService.findAuth(id);
        if (auth == null) {
            model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_DETAIL_ERROR, null, locale));
        } else {
            this.authService.delete(auth.getId());
        }
        return this.list("1", "asc", model);
    }

    @RequestMapping(value = "update/{id}", method = GET)
    public String update(@PathVariable("id") String id, Model model, Locale locale) {
        Auth auth = this.authService.findAuth(id);
        if (auth == null) {
            model.addAttribute("error", this.messageSource.getMessage(MessageUtil.APP_MESSAGE_AUTH_DETAIL_ERROR, null, locale));
            this.list("1", "asc", model);
        }
        model.addAttribute("auth", auth);
        return "auth/update";
    }

    @RequestMapping(value = "update", params = "confirm")
    public String updateConfirm(@Validated AuthForm form, BindingResult result, Model model, Locale locale) {
        if (result.hasErrors()) {
            return createRedo(form);
        }
        model.addAttribute("auth", form);
        return "auth/updateConfirm";
    }

    @RequestMapping(value = "update", params = "update")
    public String updateUpdate(@Validated AuthForm form, BindingResult result, Model model, Locale locale) {
        // 既に存在するかをチェックする
        if (result.hasErrors()) {
            return createRedo(form);
        }
        // 登録処理
        this.authService.update(form.getId(), form.getLoginId(), form.getPass());
        return this.list("1", "asc", model);
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
    public String createConfirm(@Validated AuthForm form, BindingResult result, Model model, Locale locale) {
        // 既に存在するかをチェックする
        this.validate(this.authService, form, result);
        if (result.hasErrors()) {
            return createRedo(form);
        }
        model.addAttribute("auth", form);
        return "auth/createConfirm";
    }

    private void validate(AuthService authService, AuthForm form, BindingResult result) {
        if (authService.findLoginId(form.getLoginId()) != null) {
            result.rejectValue("loginId", MessageUtil.APP_MESSAGE_AUTH_OVERLAP_ERROR);
        }
    }

    @RequestMapping(value = "create", params = "update")
    public String createUpdate(@Validated AuthForm form, BindingResult result, Model model, Locale locale) {
        // 既に存在するかをチェックする
        this.validate(this.authService, form, result);
        if (result.hasErrors()) {
            return createRedo(form);
        }
        // 登録処理
        this.authService.save(form.getLoginId(), form.getPass());
        return this.list("1", "asc", model);
    }

}
