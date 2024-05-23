package jp.mydns.kon104.study.sboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.repository.AccountsRepository;
import jp.mydns.kon104.study.sboot.service.AccountsServiceImpl;
import jp.mydns.kon104.study.sboot.testutil.TestUtilMockBaseBuilder;
import jp.mydns.kon104.study.sboot.testutil.TestUtilMockHelper;
import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private static AccountsRepository mockRepository = TestUtilMockBaseBuilder.buildAccountsRepository();
	
	@InjectMocks
	private static AccountsServiceImpl accountService;

	private static List<Accounts> accounts;

	@BeforeEach
	public void eachInitialization() {
		UtilEnvInfo.showCurrentClassMethod();
		accounts = TestUtilMockHelper.composeAccounts();
		mockRepository  = TestUtilMockHelper.trainAcRepoFindByUidAndPassword(mockRepository, accounts);
	}

	@Test
	public void indexTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		Accounts account = new Accounts();
		this.mockMvc.perform(get("/accounts/"))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
	}

	@Test
	public void searchパラメータ無しTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		Accounts account = accountService.searchAccount(0, null);
		this.mockMvc.perform(get("/accounts/search"))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
	}

	@Test
	public void searchパラメータ有りTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
//		Accounts account = accounts.get(3);
		Accounts account = new Accounts(2, "Nancy", "pw2");
		this.mockMvc.perform(post("/accounts/search")
				.param("uid", String.valueOf(account.getUid()))
				.param("password", account.getPassword()))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
		// 課題：HTTP送信先で動いている AccountsController までモックの注入方法(DI)が分からない
	}

}
