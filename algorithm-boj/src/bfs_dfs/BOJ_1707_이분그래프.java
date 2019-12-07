package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-03.
 * https://www.acmicpc.net/problem/1707
 */

public class BOJ_1707_이분그래프 {

	private static ArrayList<ArrayList<Integer>> graph;
	private static Visit[] visits;


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		//Test Case
		for (int i = 0; i < t; i++) {
			int v = scanner.nextInt();//정점
			int e = scanner.nextInt();//간선
			graph = new ArrayList<ArrayList<Integer>>();

			for (int z = 0; z < v + 1; z++) {
				graph.add(new ArrayList<>());
			}

			//간선 입력
			for (int j = 0; j < e; j++) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				graph.get(start).add(end);
				graph.get(end).add(start);
			}

			check();
		}
	}

	private static void check() {
		visits = new Visit[graph.size()];

		for (int i = 1; i < visits.length; i++) {
			visits[i] = new Visit();
		}

		for (int i = 1; i < visits.length; i++) {
			if (!visits[i].isVisit()) {
				dfs(i, true);//start
			}
		}

		boolean result = true;
		for (int i = 1; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				int k = graph.get(i).get(j);
				if (visits[i].isCheck() == visits[k].isCheck()) {
					result = false;//연결되어 있는것중 하나라도 같은 flag 가 있으면
				}
			}
		}

		System.out.println(result ? "YES" : "NO");
	}

	private static void dfs(int start, boolean flag) {
		visits[start].setVisit(true);
		visits[start].setCheck(flag);

		for(int end : graph.get(start)) {
			if (!visits[end].isVisit()) {//방문하지 않았다면
				dfs(end, !flag);
			}
		}
	}
}


class Visit {

	private boolean visit;//기존처럼 방문여부
	private boolean check;//이분그래프 체크여부

	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isVisit() {
		return visit;
	}

	public boolean isCheck() {
		return check;
	}
}
