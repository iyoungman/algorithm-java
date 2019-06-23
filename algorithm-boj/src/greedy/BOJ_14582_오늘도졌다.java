package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-05.
 * https://www.acmicpc.net/problem/14582
 */

public class BOJ_14582_오늘도졌다 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isReversal = false, isWinState = false;
		int[] ulRim = new int[9];
		int[] startRink = new int[9];

		//울림 입력
		for (int i = 0; i < 9; i++) {
			ulRim[i] = scanner.nextInt();
		}

		//스타트링크 입력
		for (int i = 0; i < 9; i++) {
			startRink[i] = scanner.nextInt();
		}

		int sumScoreByUlRim = 0;
		int sumScoreByStartRink = 0;
		for (int i = 0; i < 9; i++) {
			sumScoreByUlRim = sumScoreByUlRim + ulRim[i];
			if(sumScoreByUlRim > sumScoreByStartRink) {
				isWinState = true;
				isReversal = false;
			}

			sumScoreByStartRink = sumScoreByStartRink + startRink[i];
			if(sumScoreByStartRink > sumScoreByUlRim && isWinState) {
				isWinState = false;
				isReversal = true;
			}
		}

		System.out.println((isReversal) ? "Yes" : "No");
	}
}
