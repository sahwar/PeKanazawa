package jp.co.pekanazawa.component.login;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class LoginDto {
    private int id;
    private String loginId;

    public void login(int id, String loginId) {
        this.setId(id);
        this.setLoginId(loginId);
    }

    public boolean isLogin() {

        if (this.getId() <= 1 &&
                (!StringUtils.isEmpty(this.getLoginId())) &&
                this.getLoginId().length() >= 1) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

}
