package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by YoungMan on 2019-06-27.
 * https://www.acmicpc.net/problem/7576
 * 0인 값에만 집중하면 쉽게 해결
 */

public class BOJ_7576_토마토 {

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static int[][] map;
	private static int[] xMove = {0, 0, -1, 1};//상하좌우
	private static int[] yMove = {-1, 1, 0, 0};//상하좌우
	private static Queue<Integer> xQueue = new LinkedList<>();
	private static Queue<Integer> yQueue = new LinkedList<>();


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = stoi(st.nextToken());//가로
		int n = stoi(st.nextToken());//세로
		int max = 0;
		map = new int[n][m];

		//입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int a = stoi(st.nextToken());
				if (a == 1) {
					xQueue.offer(i);
					yQueue.offer(j);
				}
				map[i][j] = a;
			}
		}

		bfs();

		//출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = (max > map[i][j]) ? max : map[i][j];
			}
		}
		System.out.println(max - 1);
	}

	private static void bfs() {
		while (!xQueue.isEmpty()) {
			checkUpDownLeftRight(xQueue.poll(), yQueue.poll());
		}
	}

	private static void checkUpDownLeftRight(int x, int y) {

		for (int i = 0; i < xMove.length; i++) {//상하좌우 검사
			int tempX = x + xMove[i];
			int tempY = y + yMove[i];

			if (checkArrayIndexOut(tempX, tempY) || map[tempX][tempY] != 0) {
				continue;
			}

			if (map[tempX][tempY] == 0) {
				map[tempX][tempY] = map[x][y] + 1;//전것의 + 1
				xQueue.offer(tempX);
				yQueue.offer(tempY);
			}
		}
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x >= map.length || y < 0 || y >= map[0].length;
	}
}
