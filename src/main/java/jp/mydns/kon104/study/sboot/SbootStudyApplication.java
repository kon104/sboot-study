package jp.mydns.kon104.study.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jp.mydns.kon104.study.sboot.util.UtilEnvInfo;

@SpringBootApplication
public class SbootStudyApplication {

	public static void main(String[] args) {
		UtilEnvInfo.showCurrentClassMethod();
		SpringApplication.run(SbootStudyApplication.class, args);
	}

}
