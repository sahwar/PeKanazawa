package web.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.spring.jpa.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}