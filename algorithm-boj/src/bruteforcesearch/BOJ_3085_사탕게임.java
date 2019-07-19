package bruteforcesearch;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-16.
 * https://www.acmicpc.net/problem/3085
 * 범위가 작기 때문에 완전 탐색
 */

public class BOJ_3085_사탕게임 {

	private static int[] xMove = {0, 1};//우하
	private static int[] yMove = {1, 0};//우하
	private static int max;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//입력
		int n = scanner.nextInt();
		scanner.nextLine();//개행 제거
		char[][] candies = new char[n][n];

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				candies[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check(i, j, candies, 0);
				check(i, j, candies, 1);
			}
		}

		//결과 출력
		System.out.println(max);
	}

	private static void check(int i, int j, char[][] copyCandies, int move) {
		int moveX = i + xMove[move];
		int moveY = j + yMove[move];
		if (checkIndexOut(moveX, moveY, copyCandies.length - 1)) {//범위에 벗어나면
			return;
		}

		char from = copyCandies[i][j];
		char to = copyCandies[moveX][moveY];
		if (from == to) {//인접한 색상이 같으면
			return;
		}

		//위치 교환
		copyCandies[i][j] = to;
		copyCandies[moveX][moveY] = from;

		//가로 체크
		for (char[] candiesOfLine : copyCandies) {
			int temp = 1;
			for (int z = 0; z < copyCandies.length - 1; z++) {
				if (candiesOfLine[z] == candiesOfLine[z + 1]) {
					temp++;
				} else {
					max = Math.max(max, temp);
					temp = 1;
				}
			}
			max = Math.max(max, temp);
		}

		//세로 체크
		for (int k = 0; k < copyCandies.length; k++) {
			int temp = 1;
			for (int z = 0; z < copyCandies.length - 1; z++) {
				if (copyCandies[z][k] == copyCandies[z + 1][k]) {
					temp++;
				} else {
					max = Math.max(max, temp);
					temp = 1;
				}
			}
			max = Math.max(max, temp);
		}

		//위치 제자리
		copyCandies[i][j] = from;
		copyCandies[moveX][moveY] = to;
	}

	private static boolean checkIndexOut(int i, int j, int n) {
		return i > n || j > n;
	}
}
