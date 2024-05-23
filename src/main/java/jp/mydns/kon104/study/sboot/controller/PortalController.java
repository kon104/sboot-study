package jp.mydns.kon104.study.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@Controller
public class PortalController {

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		UtilEnvInfo.showCurrentClassMethod();
		mav.setViewName("portal/index");
		return mav;
	}

	@GetMapping("/hello")
	public ModelAndView hello(ModelAndView mav) {
		UtilEnvInfo.showCurrentClassMethod();
		mav.setViewName("portal/hello");
		return mav;
	}

}
