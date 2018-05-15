package com.restart.algorithm;

import java.util.Scanner;

public class GroupTextChecker {
	public static int[] visitedText = new int[26];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 한번 방문했던 단어가 또 나오면 그룹단어가 아니다 .
		// 단어는 소문자로만 되어있다. 97 ~ 122

		int testCase = sc.nextInt();
		sc.nextLine();
		int ret = 0;
		for (int t = 0; t < testCase; t++) {
			boolean groupText = true;
			String inputText = sc.nextLine();
			String texts[] = inputText.split("");
			// visitedText초기화
			settingVistText();

			// 그룹단어 체크
			for (int i = 0; i < texts.length - 1; i++) {
				int j = i + 1;
				if (texts[i].equals(texts[j])) {
					continue;
				} else if (!texts[i].equals(texts[j]) && visitedText[(int) texts[j].charAt(0) - 97] == 0) {
					visitedText[(int) texts[i].charAt(0) - 97] = 1;
				} else if (!texts[i].equals(texts[j]) && visitedText[(int) texts[j].charAt(0) - 97] == 1) {
					groupText = false;
				}
			}

//			System.out.println(groupText);
			if ( groupText ) {
				ret++;
			}
		}
		System.out.println(ret);

	}

	private static void settingVistText() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			visitedText[i] = 0;
		}
	}

}
