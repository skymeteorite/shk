package com.xz.team.view;

import java.util.Scanner;

/**
 * 
 * @Description
 * @author Agiz  Email:1229836201@qq.com
 * @version
 * @date 2020年5月4日下午2:56:06
 */
public class TSUtility {
	
	private static Scanner scanner = new Scanner(System.in);
	public static char readMenuSelection() {
		char c;
		for(;;) {
			String string = readKeyBoard(1, false);
			c = string.charAt(0);
			if(c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.println("选择错误，请重新输入：");
			}else break;
		}
		return c;
	}
	//提示等待，直到用户按回车后返回
	public static void readReturn() {
		System.out.println("按回车继续...");
		readKeyBoard(10, true);
	}
	
	public static int readInt() {
		int n;
		for(;;) {
			String string = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(string);
				break;
			}catch (NumberFormatException e) {
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	//读取Y或N，返回
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String string = readKeyBoard(1, false).toUpperCase();
			c = string.charAt(0);
			if(c == 'Y' || c == 'N')
				break;
			else
				System.out.println("选择错误，请重新输入：");
		}
		return c;
	}
	
	
	//limit字符串长度限制，字符串为空串是true返回空串，false重新输入，即读取回车符
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.length() == 0) {
				if(blankReturn)	return line;
				else continue;
			}
			if(line.length() < 1 || line.length() > limit) {
				System.out.println("输入长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
}
