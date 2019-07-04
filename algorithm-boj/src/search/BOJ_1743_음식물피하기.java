package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-04.
 * https://www.acmicpc.net/problem/1743
 */

public class BOJ_1743_음식물피하기 {

	private static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	private static boolean visit[][];
	private static int tempResult, finalResult;
	private static int n, m, k;
	private static int[] xMove = {0, 0, -1, 1};//상하좌우
	private static int[] yMove = {-1, 1, 0, 0};//상하좌우

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();//세로
		m = scanner.nextInt();//가로
		k = scanner.nextInt();//음식물 쓰래기 개수
		visit = new boolean[n + 1][m + 1];

		//초기화
		for (int i = 0; i < n + 1; i++) {
			map.add(new ArrayList<>());
		}

		//음식물 쓰래기 좌표
		for (int i = 0; i < k; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			map.get(r).add(c);
		}

		//계산
		for (int i = 1; i < n + 1; i++) {
			for (int j : map.get(i)) {
				if (!visit[i][j]) {
					tempResult = 0;
					dfs(i, j);
					finalResult = Math.max(finalResult, tempResult);
				}
			}
		}

		//출력
		System.out.println(finalResult);
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		tempResult++;

		for (int i = 0; i < 4; i++) {//상하좌우 검사
			int nextX = x + xMove[i];
			int nextY = y + yMove[i];

			if (!checkArrayIndexOut(nextX, nextY) && !visit[nextX][nextY] && map.get(nextX).contains(nextY)) {
				visit[nextX][nextY] = true;
				dfs(nextX, nextY);
			}
		}
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x > n || y < 0 || y > m;
	}
}
