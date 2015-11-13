package jp.co.pekanazawa.auth.domain.repository;

import jp.co.pekanazawa.auth.domain.model.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {

    public Auth findByLoginIdAndPass(String loginId, String pass);

    public Auth findById(int id);
}
