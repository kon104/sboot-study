package jp.mydns.kon104.study.sboot.controller;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
@AutoConfigureMockMvc
public class PortalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private static PortalController portalController;

	@Test
	public void indexRequestByHttpTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("portal/index"));
	}

	@Test
	public void helloRequestByHttpTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		this.mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(view().name("portal/hello"));
	}

	@Test
	public void indexTest() {
		UtilEnvInfo.showCurrentClassMethod();
		ModelAndView mav = new ModelAndView();
		mav = portalController.index(mav);
		assertThat(mav.getViewName()).isEqualTo("portal/index");
	}

	@Test
	public void helloTest() {
		UtilEnvInfo.showCurrentClassMethod();
		ModelAndView mav = new ModelAndView();
		mav = portalController.hello(mav);
		assertThat(mav.getViewName()).isEqualTo("portal/hello");
	}

}
