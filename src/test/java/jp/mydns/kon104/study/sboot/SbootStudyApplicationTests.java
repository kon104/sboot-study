package jp.mydns.kon104.study.sboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootTest
class SbootStudyApplicationTests {

	@Test
	void contextLoads() {
		UtilEnvInfo.showCurrentClassMethod();
	}

}
