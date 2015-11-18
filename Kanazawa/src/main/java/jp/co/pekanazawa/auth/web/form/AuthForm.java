package jp.co.pekanazawa.auth.web.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class AuthForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String loginId;
    private String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotBlank
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @NotBlank
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
