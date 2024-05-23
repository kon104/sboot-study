package jp.mydns.kon104.study.sboot.util;

public class UtilEnvInfo {

	public static void showCurrentClassMethod() {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.printf(">> %s#%s\n", className, methodName);
	}
}
