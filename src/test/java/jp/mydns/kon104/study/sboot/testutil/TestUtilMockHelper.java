package jp.mydns.kon104.study.sboot.testutil;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;
import jp.mydns.kon104.study.sboot.service.AccountsService;

public class TestUtilMockHelper {

	public static List<Accounts> composeAccounts() {
		List<Accounts> list = new ArrayList<>();
		list.add(new Accounts(1, "佐藤", "1234567"));
		list.add(new Accounts(2, "鈴木", "abcdefg"));
		list.add(new Accounts(3, "高橋", "hijklmn"));
		list.add(new Accounts(4, "田中", "opqrstu"));
		list.add(new Accounts(5, "伊藤", "vwxyzAB"));
		return list;
	}
	
	public static AccountsRepository trainAcRepoFindByUidAndPassword(AccountsRepository mock, List<Accounts> list) {
		for (Iterator<Accounts> itr = list.iterator(); itr.hasNext();) {
			Accounts account = itr.next();
			when(mock.findByUidAndPassword(account.getUid(), account.getPassword())).thenReturn(account);
		}
		return mock;
	}

	public static AccountsService trainAcServiceSearchAccount(AccountsService mock, List<Accounts> list) {
		for (Iterator<Accounts> itr = list.iterator(); itr.hasNext();) {
			Accounts account = itr.next();
			when(mock.searchAccount(account.getUid(), account.getPassword())).thenReturn(account);
		}
		return mock;
	}

}
