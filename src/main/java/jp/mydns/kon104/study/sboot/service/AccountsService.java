package jp.mydns.kon104.study.sboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;

@Service
public class AccountsService {

	@Autowired
	private final AccountsRepository accountsRepository;

	AccountsService(AccountsRepository accountsRepository){
		this.accountsRepository = accountsRepository;
	}

	public Accounts searchAccount(int id,String password) {
		return accountsRepository.findByUidAndPassword(id,password);
	}

    
}
