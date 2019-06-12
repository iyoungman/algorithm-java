package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-11.
 */

public class BOJ_11724_연결요소의개수 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visit;
	static int resultCount = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();
		int E = scanner.nextInt();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visit = new boolean[graph.size()];

		for (int i = 0; i < E; i++) {
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

	static void dfs(int start) {
		visit[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			int end = graph.get(start).get(i);
			if (!visit[end]) {//방문하지 않았다면
				dfs(end);
			}
		}
	}
}
