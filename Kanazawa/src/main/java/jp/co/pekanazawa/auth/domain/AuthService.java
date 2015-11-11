package jp.co.pekanazawa.auth.domain;

import jp.co.pekanazawa.auth.domain.model.Auth;
import jp.co.pekanazawa.auth.domain.repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
}
