package jp.mydns.kon104.study.sboot.testutil;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.mydns.kon104.study.sboot.bean.Account;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;
import jp.mydns.kon104.study.sboot.service.AccountsService;

public class TestUtilMockHelper {

	public static List<Account> composeAccounts() {
		List<Account> list = new ArrayList<>();
		list.add(new Account(1, "佐藤", 10, "北海道"));
		list.add(new Account(2, "鈴木", 20, "宮城県"));
		list.add(new Account(3, "高橋", 30, "神奈川県"));
		list.add(new Account(4, "田中", 40, "愛知県"));
		list.add(new Account(5, "伊藤", 50, "大阪府"));
		return list;
	}

	public static AccountsRepository trainAcRepoFindByUidAndAgeOrderByUid(AccountsRepository mock, List<Account> list) {
		for (Iterator<Account> itr = list.iterator(); itr.hasNext();) {
			Account account = itr.next();
			List<Account> accounts = new ArrayList<>();
			accounts.add(account);
			when(mock.findByUidAndAgeOrderByUid(account.getUid(), account.getAge())).thenReturn(accounts);
		}
		return mock;
	}

	public static AccountsService trainAcServiceSearchAccount(AccountsService mock, List<Account> list) {
		for (Iterator<Account> itr = list.iterator(); itr.hasNext();) {
			Account account = itr.next();
			List<Account> accounts = new ArrayList<>();
			accounts.add(account);
			when(mock.searchAccount(account.getUid(), account.getAge())).thenReturn(accounts);
		}
		return mock;
	}

}
