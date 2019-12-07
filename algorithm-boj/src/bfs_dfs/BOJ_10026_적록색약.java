package bfs_dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-17.
 * https://www.acmicpc.net/problem/10026
 */

public class BOJ_10026_적록색약 {

	private static char[][] graph;
	private static int[][] visit;
	private static int[] xMove = {0, 0, -1, 1};//상하좌우
	private static int[] yMove = {-1, 1, 0, 0};//상하좌우
	private static int count;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		graph = new char[n][n];
		visit = new int[n][n];

		//입력
		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = line.charAt(j);
			}
		}

		//색약이 아닌사람
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0) {
					count++;
					dfsByNotColorWeakness(i, j);
				}
			}
		}
		int numOfNotColorWeakness = count;

		count = 0;
		for (int[] line : visit) {
			Arrays.fill(line, 0);
		}

		//색약인 사람
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0) {
					count++;
					dfsByColorWeakness(i, j);
				}
			}
		}
		int numOfColorWeakness = count;

		//출력
		System.out.println(numOfNotColorWeakness + " " + numOfColorWeakness);
	}

	private static void dfsByNotColorWeakness(int x, int y) {
		visit[x][y] = count;

		for (int i = 0; i < 4; i++) {
			int moveX = x + xMove[i];
			int moveY = y + yMove[i];

			if(!checkArrayIndexOut(moveX, moveY) && graph[x][y] == graph[moveX][moveY] && visit[moveX][moveY] == 0) {
				dfsByNotColorWeakness(moveX, moveY);
			}
		}
	}

	private static void dfsByColorWeakness(int x, int y) {
		visit[x][y] = count;

		for (int i = 0; i < 4; i++) {
			int moveX = x + xMove[i];
			int moveY = y + yMove[i];

			if(!checkArrayIndexOut(moveX, moveY) && weaknessSameCondition(graph[x][y], graph[moveX][moveY]) && visit[moveX][moveY] == 0) {
				dfsByColorWeakness(moveX, moveY);
			}
		}
	}

	private static boolean weaknessSameCondition(char before, char after) {
		if(before == 'B') {
			return after == 'B';
		} else {
			return after == 'R' || after == 'G';
		}
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x >= graph.length || y < 0 || y >= graph[0].length;
	}
}
