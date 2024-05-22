package jp.mydns.kon104.study.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.mydns.kon104.study.sboot.bean.Accounts;
import jp.mydns.kon104.study.sboot.service.AccountsService;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	private final AccountsService accountsService;

	public AccountsController(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@GetMapping("/")
	public String index(Model model) {
		System.out.println("Started AccountsController#index()");
		model.addAttribute("rs", new Accounts());
		return "accounts/index";
	}

	@RequestMapping("/search")
	public String search(Model model,
			@RequestParam(name = "uid", required = false, defaultValue = "0") int uid,
			@RequestParam(name = "password", required = false) String password) {
		System.out.println("Started AccountsController#search()");
		Accounts account = accountsService.searchAccount(uid, password);
		model.addAttribute("rs", account);
		return "accounts/index";
	}

}
