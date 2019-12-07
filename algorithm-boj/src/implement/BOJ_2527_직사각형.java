package implement;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-05.
 * https://www.acmicpc.net/problem/2527
 * http://blog.naver.com/PostView.nhn?blogId=xtelite&logNo=50173791450&parentCategoryNo=&categoryNo=2&viewDate=&isShowPopularPosts=false&from=postView
 */

public class BOJ_2527_직사각형 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int t = 0; t < 4; t++) {
			int[] squareOne = new int[4];
			int[] squareTwo = new int[4];

			//좌표 입력
			for (int i = 0; i < 8; i++) {
				if (i < 4) {
					squareOne[i] = scanner.nextInt();
				} else {
					squareTwo[i - 4] = scanner.nextInt();
				}
			}

			//결과 출력
			System.out.println(getOverlapCode(squareOne, squareTwo));
		}

	}

	private static String getOverlapCode(int[] squareOne, int[] squareTwo) {
		int overlapLeftX = Math.max(squareOne[0], squareTwo[0]);
		int overlapLeftY = Math.max(squareOne[1], squareTwo[1]);
		int overlapRightX = Math.min(squareOne[2], squareTwo[2]);
		int overlapRightY = Math.min(squareOne[3], squareTwo[3]);

		if (overlapLeftX == overlapRightX && overlapLeftY == overlapRightY) {
			return "c";
		} else if (overlapLeftX == overlapRightX || overlapLeftY == overlapRightY) {
			return "b";
		} else if (overlapLeftX <= overlapRightX && overlapLeftY <= overlapRightY) {
			return "a";
		} else {
			return "d";
		}
	}
}
