package jp.mydns.kon104.study.sboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbootStudyApplicationTests {

	@Test
	void contextLoads() {
		System.out.printf("%s#%s\n",
				new Object(){}.getClass().getEnclosingClass().getName(),
				new Object(){}.getClass().getEnclosingMethod().getName());
	}

}
