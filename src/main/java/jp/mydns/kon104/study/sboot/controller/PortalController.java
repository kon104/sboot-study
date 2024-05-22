package jp.mydns.kon104.study.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("Started PortalController#index()");
		return "portal/index";
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println( "Started PortalController#hello()" );
		return "portal/hello";
	}

}
