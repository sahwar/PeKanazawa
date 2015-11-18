package jp.co.pekanazawa.auth.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.domain.repository.AuthRepository;
import jp.co.pekanazawa.common.util.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public Auth login(String loginId, String pass) {
        // TODO 未実装(RepositoryでパスワードをMD5とする)
        String md5Pass = pass;
        return this.authRepository.findByLoginIdAndPass(loginId, md5Pass);
    }

    public Auth findAuth(String id) {
        return this.authRepository.findById(Integer.valueOf(id));
    }

    public Page<Auth> findList(int page, List<String> sortKey, Sort.Direction sortType) {
        return this.authRepository.findAll(new PageRequest(page, PageUtil.PAGE_NUM));
    }

    public Auth findLoginId(String loginId) {
        return this.authRepository.findByLoginId(loginId);
    }

    public Auth save(String loginId, String pass) {
        Auth auth = new Auth();
        auth.setLoginId(loginId);
        auth.setPass(pass);
        Date date = new Date();
        auth.setCreated(date);
        auth.setDeleted(null);
        auth.setUpdated(new Timestamp(date.getTime()));
        auth = this.authRepository.save(auth);
        this.authRepository.flush();
        return auth;
    }
}
