package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-11.
 * https://www.acmicpc.net/problem/11724
 */

public class BOJ_11724_연결요소의개수 {

	private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private static boolean[] visit;
	private static int resultCount = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt();
		int e = scanner.nextInt();

		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visit = new boolean[graph.size()];

		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			graph.get(start).add(end);
			graph.get(end).add(start);
		}

		for(int i = 1; i<graph.size(); i++) {
			if(!visit[i]) {//방문하지 않았다면
				dfs(i);
				resultCount++;
			}
		}

		System.out.println(resultCount);
	}

	private static void dfs(int start) {
		visit[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			int end = graph.get(start).get(i);
			if (!visit[end]) {//방문하지 않았다면
				dfs(end);
			}
		}
	}
}
