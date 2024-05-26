package jp.mydns.kon104.study.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.mydns.kon104.study.sboot.bean.Account;
import jp.mydns.kon104.study.sboot.service.AccountsService;
import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private final AccountsService accountsService;

	public AccountsController(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		UtilEnvInfo.showCurrentClassMethod();
		List<Account> accounts = accountsService.searchAccount();
		mav.addObject("rs", accounts);
		mav.setViewName("accounts/index");
		return mav;
	}

	@RequestMapping("/search")
	public ModelAndView search(ModelAndView mav,
			@RequestParam(name = "uid", required = false, defaultValue = "0") int uid,
			@RequestParam(name = "age", required = false, defaultValue = "0") int age) {
		UtilEnvInfo.showCurrentClassMethod();
		System.out.printf("\tuid=%d, age=%d\n", uid, age);
		List<Account> accounts = accountsService.searchAccount(uid, age);
		mav.addObject("rs", accounts);
		mav.setViewName("accounts/index");
		return mav;
	}

}
