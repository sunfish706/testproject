package jp.co.f1.app.baseball;

import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {

		System.out.println("---野球ゲームプログラム開始---");

		// 正解数字を格納する配列
		int[] answer = new int[3];

		while (true) {

			// 3桁の正解数字を生成
			for (int i = 0; i < answer.length; i++) {
				answer[i] = (int) (Math.random() * 10);
			}

			System.out.println("\n3桁のランダム数字(正解数字)は" + answer[0] + answer[1]
					+ answer[2] + "です。");

			// 生成した数字のユニークチェック
			if (isUniqueArray(answer)) {
				System.out.println("⇒ユニークです。");
				break;
			}

			System.out.println("⇒重複しています。");

		}

		Scanner sc = new Scanner(System.in);
		int[] playerNum = new int[3];
		int numberOfTry = 0;

		while (true) {

			// ユーザーの入力
			System.out.print("\n3桁の数字を入力してください＞＞");
			String inputNum = sc.nextLine();

			// 桁ごとに配列に格納
			playerNum[0] = Integer.parseInt(inputNum.substring(0, 1));
			playerNum[1] = Integer.parseInt(inputNum.substring(1, 2));
			playerNum[2] = Integer.parseInt(inputNum.substring(2));

			// 入力数字の重複チェック
			if (!isUniqueArray(playerNum)) {
				System.out.println("⇒重複しています。");
				continue;
			}

			System.out.println("⇒ユニークです。");

			// トライ回数を1増やす
			numberOfTry++;

			// ストライクのカウント
			int strikeCount = 0;
			for (int i = 0; i < playerNum.length; i++) {
				if (playerNum[i] == answer[i]) {
					strikeCount++;
				}
			}

			// ボールのカウント
			int ballCount = 0;
			for (int i = 0; i < playerNum.length; i++) {
				for (int j = 0; j < playerNum.length; j++) {
					if (i != j && playerNum[i] == answer[j]) {
						ballCount++;
					}
				}
			}

			System.out.println("判定：" + strikeCount + "ストライク、" + ballCount
					+ "ボールです。");

			// ストライク数が3になったとき、ループを抜ける
			if (strikeCount == 3) {
				break;
			}

		}

		System.out.println("\n" + numberOfTry + "回トライし、3桁数字を当てました。You Win!!");

		System.out.println("\n---野球ゲームプログラム終了---");

	}

	static boolean isUniqueArray(int[] tmpArray) {

		for (int i = 0; i < tmpArray.length; i++) {
			for (int j = i + 1; j > tmpArray.length; j++) {
				if (tmpArray[i] == tmpArray[j]) {
					return false;
				}
			}
		}

		return true;
	}
}