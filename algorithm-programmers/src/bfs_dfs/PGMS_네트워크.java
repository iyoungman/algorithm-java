package bfs_dfs;

/**
 * Created by YoungMan on 2019-09-27.
 */

public class PGMS_네트워크 {

	private static boolean[] visit;

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

		System.out.println(solution(n, computers));
	}

	private static int solution(int n, int[][] computers) {
		visit = new boolean[n];

		int result = 0;
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if (computers[i][j] == 1 && !visit[j]) {
					dfs(j, computers);
					result++;
				}
			}
		}

		return result;
	}

	private static void dfs(int computer, int[][] computers) {
		visit[computer] = true;

		int index = 0;
		for (int other : computers[computer]) {
			if (other == 1 && !visit[index]) {
				dfs(index, computers);
			}
			index++;
		}
	}
}
