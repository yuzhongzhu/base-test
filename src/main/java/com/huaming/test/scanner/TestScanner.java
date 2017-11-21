package com.huaming.test.scanner;

import java.io.Console;

public class TestScanner {
	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("请输入");
		String lineStr = scanner.nextLine();
		System.out.println(""+lineStr);
		System.out.println("继续输入");
		while(scanner.hasNext()){
			String temp = scanner.next();
			System.out.println(""+temp);
		}*/
		Console console = System.console();
		String userName = console.readLine("user name");
		char[] passwords = console.readPassword("password");
	}
}
