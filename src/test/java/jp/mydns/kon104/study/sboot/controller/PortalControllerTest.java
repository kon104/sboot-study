package jp.mydns.kon104.study.sboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
@AutoConfigureMockMvc
public class PortalControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void indexTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("portal/index"));
	}

	@Test
	public void helloTest()  throws Exception {
		UtilEnvInfo.showCurrentClassMethod();
		this.mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(view().name("portal/hello"));
	}

}
