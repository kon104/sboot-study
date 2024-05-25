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

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;
import jp.mydns.kon104.study.sboot.testutil.TestUtilMockHelper;
import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
public class AccountsServiceTest {

	private static List<Accounts> accounts;

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
		mockRepository  = TestUtilMockHelper.trainAcRepoFindByUidAndPassword(mockRepository, accounts);
	}
	
	@Test
	public void searchAccountTest() {
		UtilEnvInfo.showCurrentClassMethod();
		for (Iterator<Accounts> itr = accounts.iterator(); itr.hasNext();) {
			Accounts user = itr.next();
			Accounts result = target.searchAccount(user.getUid(), user.getPassword());
			assertThat(result.getUid()).isEqualTo(user.getUid());
			assertThat(result.getName()).isEqualTo(user.getName());
			assertThat(result.getPassword()).isEqualTo(user.getPassword());
			System.out.printf("\tuid=%s, name=%s, pw=%s\n", result.getUid(), result.getName(), result.getPassword());
		}
	}

}
