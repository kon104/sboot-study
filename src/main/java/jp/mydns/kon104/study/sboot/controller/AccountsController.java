package jp.mydns.kon104.study.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.mydns.kon104.study.sboot.bean.Accounts;
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
		mav.addObject("rs", new Accounts());
		mav.setViewName("accounts/index");
		return mav;
	}

	@RequestMapping("/search")
	public ModelAndView search(ModelAndView mav,
			@RequestParam(name = "uid", required = false, defaultValue = "0") int uid,
			@RequestParam(name = "password", required = false) String password) {
		UtilEnvInfo.showCurrentClassMethod();
		System.out.printf("\tuid=%s, password=%s\n", uid, password);
		Accounts account = accountsService.searchAccount(uid, password);
		mav.addObject("rs", account);
		mav.setViewName("accounts/index");
		return mav;
	}

}
