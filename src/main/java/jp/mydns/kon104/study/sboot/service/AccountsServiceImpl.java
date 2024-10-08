package jp.mydns.kon104.study.sboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.mydns.kon104.study.sboot.entity.Account;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService {

	private final AccountsRepository accountsRepository;

	public AccountsServiceImpl(AccountsRepository accountsRepository){
		this.accountsRepository = accountsRepository;
	}

	@Override
	public List<Account> searchAccount() {
		return accountsRepository.findAllByOrderByUid();
	}

	@Override
	public List<Account> searchAccount(int id, int age) {
		return accountsRepository.findByUidAndAgeOrderByUid(id, age);
	}

	@Override
	public Account saveAccoount(Account account) {
		return accountsRepository.save(account);
	}
}
