package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-17.
 * https://www.acmicpc.net/problem/2178
 * 최단경로 -> BFS
 * 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */

public class BOJ_2178_미로탐색 {

	private static int[][] map;
	private static int[][] visit;

	private static int[] xMove = {0, 0, -1, 1};//순서대로 상하좌우
	private static int[] yMove = {-1, 1, 0, 0};//순서대로 상하좌우

	private static Queue<Integer> xQueue = new LinkedList<Integer>();
	private static Queue<Integer> yQueue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//행
		int m = scanner.nextInt();//열
		map = new int[n][m];
		visit = new int[n][m];

		//입력
		for (int i = 0; i < n; i++) {
			String str = scanner.next();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(n, m);
		System.out.println(visit[n-1][m-1]);
	}

	private static void bfs(int n, int m) {

		visit[0][0] = 1;
		checkUpDownLeftRight(0,0);

		while (visit[n-1][m-1] == 0) {
			int frontX = xQueue.poll();
			int frontY = yQueue.poll();

			checkUpDownLeftRight(frontX, frontY);
		}
	}

	private static void checkUpDownLeftRight(int x, int y) {
		for (int i = 0; i < xMove.length; i++) {//상하좌우 검사
			int tempX = x + xMove[i];
			int tempY = y + yMove[i];

			if (checkArrayIndexOut(tempX, tempY))
				continue;

			if (map[tempX][tempY] == 1 && visit[tempX][tempY] == 0) {//길이 맞으면서 아직 방문하지 않았다면
				xQueue.offer(tempX);
				yQueue.offer(tempY);
				visit[tempX][tempY] = visit[x][y] + 1;//전것의 + 1
			}
		}
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x >= map.length || y < 0 || y >= map[0].length;
	}

}
