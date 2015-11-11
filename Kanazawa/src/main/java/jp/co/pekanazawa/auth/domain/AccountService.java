package jp.co.pekanazawa.auth.domain;

import java.util.List;

import jp.co.pekanazawa.auth.domain.model.Account;
import jp.co.pekanazawa.auth.domain.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}

}