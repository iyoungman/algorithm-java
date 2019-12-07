package bfs_dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-31.
 * https://www.acmicpc.net/problem/9466
 */

public class BOJ_9466_텀프로젝트 {

	private static int[] choice;
	private static int[] visit;
	private static int teamCount;
	private static ArrayList<Integer> numsForCycleCheck;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();//테스트 케이스

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();//학생 수
			choice = new int[n + 1];
			visit = new int[n + 1];
			teamCount = 0;

			//선택 입력
			for (int j = 1; j <= n; j++) {
				choice[j] = scanner.nextInt();
			}

			int index = 0;
			for (int j = 1; j <= n; j++) {
				if(visit[j] == 0) {
					numsForCycleCheck = new ArrayList<>();
					dfs(j, ++index);
				}
			}

			//출력
			System.out.println(n - teamCount);
		}
	}

	private static void dfs(int start, int index) {
		if(start == choice[start]) {//자기자신
			visit[start] = index;
			teamCount = teamCount + 1;
			return;
		}
		numsForCycleCheck.add(start);
		visit[start] = index;

		int next = choice[start];
		if(visit[next] == 0) {
			dfs(next, index);
		} else if(visit[next] == index) {
			teamCount = teamCount + getCycleCount(next);
		}
	}

	private static int getCycleCount(int num) {
		return numsForCycleCheck.size() - numsForCycleCheck.indexOf(num);
	}
}
