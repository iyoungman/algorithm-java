package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-05.
 * https://www.acmicpc.net/problem/1697
 * BFS를 통해 최단거리를 구한다
 */

public class BOJ_1697_숨바꼭질 {

	private static int[] visit = new int[100000 + 1];
	private static int n;//수빈
	private static int k;//동생

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();

		//결과 출력
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		visit[n] = 1;

		while (!queue.isEmpty() && queue.peek() != k) {//읽기
			int front = queue.poll();//삭제

			if (front + 1 <= 100000 && visit[front + 1] == 0) {
				queue.offer(front + 1);
				visit[front + 1] = visit[front] + 1;
			}

			if (front - 1 >= 0 && visit[front - 1] == 0) {
				queue.offer(front - 1);
				visit[front - 1] = visit[front] + 1;
			}

			if (front * 2 <= 100000 && visit[front * 2] == 0) {
				queue.offer(front * 2);
				visit[front * 2] = visit[front] + 1;
			}
		}

		return visit[k] - 1;
	}


}
