package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-23.
 * https://www.acmicpc.net/problem/1018
 * 개수가 달라도 배치가 다르기 때문에 개수만 세는 것으로는 판별할 수 없다.
 */

public class BOJ_1018_체스판다시칠하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//입력
		int n = scanner.nextInt();//행
		int m = scanner.nextInt();//열
		char[][] boards = new char[n][m];
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < line.length(); j++) {
				boards[i][j] = line.charAt(j);
			}
		}

		int min = 64;
		for (int i = 0; i + 7 < n; i++) {
			for (int j = 0; j + 7 < m; j++) {
				int startBlack = calculate(i, j, boards, 'B');//Start 가 'B'
				int startWhite = calculate(i, j, boards, 'W');//Start 가 'W'
				min = Math.min(min, Math.min(startBlack, startWhite));
			}
		}

		//결과 출력
		System.out.println(min);
	}

	private static int calculate(int x, int y, char[][] boards, char flag) {
		int count = 0;

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (boards[i][j] != flag) {//flag 와 다르면
					count++;
				}
				if(j != y + 7) {//각 행의 마지막이 아니면
					flag = (flag == 'B') ? 'W' : 'B';
				}
			}
		}

		return count;
	}

}
