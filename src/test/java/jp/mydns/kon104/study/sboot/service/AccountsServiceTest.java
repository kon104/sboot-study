package jp.mydns.kon104.study.sboot.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import jp.mydns.kon104.study.sboot.bean.Account;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;
import jp.mydns.kon104.study.sboot.testutil.TestUtilMockHelper;
import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
public class AccountsServiceTest {

	private static List<Account> accounts;

	@Mock
	private static AccountsRepository mockRepository;

	@InjectMocks
	private static AccountsServiceImpl target;

	@BeforeAll
	public static void advancePreparation() {
		UtilEnvInfo.showCurrentClassMethod();
	}

	@BeforeEach
	public void eachInitialization() {
		UtilEnvInfo.showCurrentClassMethod();
		accounts = TestUtilMockHelper.composeAccounts();
		mockRepository  = TestUtilMockHelper.trainAcRepoFindByUidAndAgeOrderByUid(mockRepository, accounts);
	}
	
	@Test
	public void searchAccountTest() {
		UtilEnvInfo.showCurrentClassMethod();
		for (Iterator<Account> itr = accounts.iterator(); itr.hasNext();) {
			Account account = itr.next();
			List<Account> results = target.searchAccount(account.getUid(), account.getAge());
			Account result = results.get(0);
			assertThat(result.getUid()).isEqualTo(account.getUid());
			assertThat(result.getName()).isEqualTo(account.getName());
			assertThat(result.getAge()).isEqualTo(account.getAge());
			assertThat(result.getAddress()).isEqualTo(account.getAddress());
			System.out.printf("\tuid=%d, name=%s, age=%d, address=%s\n", result.getUid(), result.getName(), result.getAge(), result.getAddress());
		}
	}

}
