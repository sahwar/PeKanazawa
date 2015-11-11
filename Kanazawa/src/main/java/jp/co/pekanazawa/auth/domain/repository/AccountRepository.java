package jp.co.pekanazawa.auth.domain.repository;

import jp.co.pekanazawa.auth.domain.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}