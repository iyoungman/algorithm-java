package bfs_dfs;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-12.
 * https://www.acmicpc.net/problem/2331
 * 방문여부 + 몇번째 방문인지 알아야한다
 * 따라서 visit 에 true, false 대신 0으로 초기화 해놓고 총 count(방문 번째)를 넣는다
 */

public class BOJ_2331_반복수열 {

	private static int[] visit = new int[236197];
	private static int P;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		P = scanner.nextInt();

		System.out.println(dfs(a, 1));
	}

	private static int dfs(int start, int count) {
		if (visit[start] != 0) {//이미 방문한 곳이라면
			return visit[start] - 1;//처음 방문했던 번째의 전 번째 까지가 반복하지 않은 부분의 숫자개수
		}
		visit[start] = count;

		int end = 0;
		while (start != 0) {
			end = (int) (end + (Math.pow(start % 10, P)));
			start = start / 10;
		}
		return dfs(end, count + 1);//return 값이 있다
	}
}
