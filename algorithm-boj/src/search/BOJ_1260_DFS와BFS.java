package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-10.
 */

public class BOJ_1260_DFS와BFS {

	private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private static boolean[] visit;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();//정점 개수
		int M = scanner.nextInt();//간선 개수
		int V = scanner.nextInt();//탐색을 시작할 정점 번호

		//정점 만큼 초기화
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		//간선 입력
		for (int i = 0; i < M; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			graph.get(start).add(end);
			graph.get(end).add(start);
		}

		visit = new boolean[graph.size()];
		dfs(V);

		System.out.println();
		bfs(V);
	}

	private static void dfs(int start) {
		visit[start] = true;
		System.out.print(start + " ");

		for (int i = 0; i < graph.get(start).size(); i++) {
			int end = graph.get(start).get(i);
			if (!visit[end]) {//방문하지 않았다면
				dfs(end);
			}
		}
	}

	private static void bfs(int start) {
		//방문 초기화
		visit = new boolean[graph.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int front = queue.poll();
			System.out.print(front + " ");

			for (int i = 0; i < graph.get(front).size(); i++) {
				int end = graph.get(start).get(i);
				if (!visit[end]) {//방문하지 않았다면
					visit[end] = true;
					queue.offer(end);
				}
			}
		}

	}

}

