package jp.mydns.kon104.study.sboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.mydns.kon104.study.sboot.bean.Account;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private final AccountsRepository accountsRepository;

	public AccountsServiceImpl(AccountsRepository accountsRepository){
		this.accountsRepository = accountsRepository;
	}

	@Override
	public Account searchAccount(int id, int age) {
		return accountsRepository.findByUidAndAge(id, age);
	}

}
