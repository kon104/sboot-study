package jp.mydns.kon104.study.sboot.service;

import java.util.List;

import jp.mydns.kon104.study.sboot.bean.Account;

public interface AccountsService {

	public List<Account> searchAccount();
	public List<Account> searchAccount(int id, int age);

}
