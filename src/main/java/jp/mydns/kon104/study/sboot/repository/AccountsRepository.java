package jp.mydns.kon104.study.sboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.kon104.study.sboot.bean.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {
	public List<Account> findAllByOrderByUid();
	public List<Account> findByUidAndAgeOrderByUid(int uid, int age);
}
