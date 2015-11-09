package web.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.spring.jpa.entity.Account;
import web.spring.jpa.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}
}