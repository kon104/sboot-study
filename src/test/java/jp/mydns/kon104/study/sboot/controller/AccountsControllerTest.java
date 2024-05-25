package jp.mydns.kon104.study.sboot.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import jp.mydns.kon104.study.sboot.bean.Account;
import jp.mydns.kon104.study.sboot.service.AccountsService;
import jp.mydns.kon104.study.sboot.testutil.TestUtilMockHelper;
import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static List<Account> accounts;

	@Mock
	private static AccountsService mockService;
	
	@InjectMocks
	private static AccountsController accountsController;
	
	@BeforeEach
	public void eachInitialization() {
		UtilEnvInfo.showCurrentClassMethod();
		accounts = TestUtilMockHelper.composeAccounts();
		mockService = TestUtilMockHelper.trainAcServiceSearchAccount(mockService, accounts);
	}

	@Test
	public void indexRequetByHttpTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		Account account = null;
		this.mockMvc.perform(get("/accounts/"))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
	}

	@Test
	public void searchRequetByHttpパラメータ無しTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		Account account = null;
		this.mockMvc.perform(get("/accounts/search"))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
	}

	@Test
	public void searchRequetByHttpパラメータ有りTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		Account account = new Account(2, "Nancy", 25, "kanagawa");
		this.mockMvc.perform(post("/accounts/search")
				.param("uid", String.valueOf(account.getUid()))
				.param("age", String.valueOf(account.getAge())))
			.andExpect(status().isOk())
			.andExpect(view().name("accounts/index"))
			.andExpect(model().attribute("rs", account));
	}

	@Test
	public void indexTest() {
		UtilEnvInfo.showCurrentClassMethod();
		ModelAndView mav = new ModelAndView();
		mav = accountsController.index(mav);
		Map<String, Object> map = mav.getModel();
		assertThat(mav.getViewName()).isEqualTo("accounts/index");
		assertThat(map.get("rs")).isEqualTo(null);
	}
	
	@Test
	public void searchTest() {
		UtilEnvInfo.showCurrentClassMethod();
		for (Iterator<Account> itr = accounts.iterator(); itr.hasNext();) {
			Account account = itr.next();
			ModelAndView mav = new ModelAndView();
			mav = accountsController.search(mav, account.getUid(), account.getAge());
			Map<String, Object> map = mav.getModel();
			Account result = (Account)map.get("rs");
			assertThat(mav.getViewName()).isEqualTo("accounts/index");
			assertThat(result.getUid()).isEqualTo(account.getUid());
			assertThat(result.getName()).isEqualTo(account.getName());
			assertThat(result.getAge()).isEqualTo(account.getAge());
			assertThat(result.getAddress()).isEqualTo(account.getAddress());
			System.out.printf("\tuid=%d, name=%s, age=%d, address=%s\n", result.getUid(), result.getName(), result.getAge(), result.getAddress());
		}
	}
	
}
