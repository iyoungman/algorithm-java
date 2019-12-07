package bfs_dfs;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-18.
 * https://www.acmicpc.net/problem/4963
 */

public class BOJ_4963_섬의개수 {

	private static int[][] graph;
	private static int[][] visit;

	//상 하 좌 우 좌상 좌하 우상 우하
	private static int[] xMove = {0, 0, -1, 1, -1, -1, 1, 1};
	private static int[] yMove = {-1, 1, 0, 0, -1, 1, -1, 1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int w = scanner.nextInt();//지도의 너비
			int h = scanner.nextInt();//지도의 높이
			graph = new int[h][w];
			visit = new int[h][w];

			//반복문 종료조건
			if (w == 0 && h == 0) {
				break;
			}

			//입력
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					graph[i][j] = scanner.nextInt();
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (graph[i][j] == 1 && visit[i][j] == 0) {
						cnt++;
						dfs(i, j, cnt);
					}
				}
			}

			//결과 출력
			System.out.println(cnt);
		}

	}

	private static void dfs(int x, int y, int cnt) {
		visit[x][y] = cnt;

		for (int i = 0; i < 8; i++) {
			int moveX = x + xMove[i];
			int moveY = y + yMove[i];

			if(!checkArrayIndexOut(moveX, moveY) && graph[moveX][moveY] == 1 && visit[moveX][moveY] == 0) {
				dfs(moveX, moveY, cnt);
			}
		}
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x >= graph.length || y < 0 || y >= graph[0].length;
	}
}
