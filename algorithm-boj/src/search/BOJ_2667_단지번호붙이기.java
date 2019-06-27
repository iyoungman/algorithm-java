package search;

import java.util.*;

/**
 * Created by YoungMan on 2019-06-13.
 * https://www.acmicpc.net/problem/2667
 */

public class BOJ_2667_단지번호붙이기 {

	private static int[][] map;
	private static boolean[][] visit;
	private static ArrayList<Integer> results = new ArrayList<>();

	private static int[] xMove = {0, 0, -1, 1};//순서대로 상하좌우
	private static int[] yMove = {-1, 1, 0, 0};//순서대로 상하좌우

	private static Queue<Integer> xQueue;
	private static Queue<Integer> yQueue;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];

		//입력
		for (int i = 0; i < N; i++) {
			String str = scanner.next();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {//단지가 1이고 아직 방문처리되지 않았다면
					results.add(bfs(i, j));
				}
			}
		}

		System.out.println(results.size());
		Collections.sort(results);

		for (int i : results) {
			System.out.println(i);
		}
	}

	private static int bfs(int x, int y) {

		xQueue = new LinkedList<Integer>();//x 좌표를 넣는 큐
		yQueue = new LinkedList<Integer>();//y 좌표를 넣는 큐
		visit[x][y] = true;
		int count = 1;

		count = count + checkUpDownLeftRight(x, y);

		while (!xQueue.isEmpty() && !yQueue.isEmpty()) {
			int frontX = xQueue.poll();
			int frontY = yQueue.poll();
			count = count + checkUpDownLeftRight(frontX, frontY);
		}

		return count;
	}

	private static int checkUpDownLeftRight(int x, int y) {
		int count = 0;
		for (int i = 0; i < xMove.length; i++) {//상하좌우 검사
			int tempX = x + xMove[i];
			int tempY = y + yMove[i];

			if (checkArrayIndexOut(tempX, tempY))
				continue;

			if (map[tempX][tempY] == 1 && !visit[tempX][tempY]) {
				xQueue.offer(tempX);
				yQueue.offer(tempY);
				visit[tempX][tempY] = true;
				count++;
			}
		}
		return count;
	}

	private static boolean checkArrayIndexOut(int x, int y) {
		return x < 0 || x >= map.length || y < 0 || y >= map.length;
	}

}


