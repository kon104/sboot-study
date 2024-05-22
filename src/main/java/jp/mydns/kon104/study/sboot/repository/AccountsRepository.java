package jp.mydns.kon104.study.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.mydns.kon104.study.sboot.bean.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
	public Accounts findByUidAndPassword(int uid, String password);
}
