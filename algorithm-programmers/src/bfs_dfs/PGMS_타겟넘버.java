package bfs_dfs;

/**
 * Created by YoungMan on 2019-09-27.
 * 경우의 수 문제를 dfs 로 풀면 유용하다
 */

public class PGMS_타겟넘버 {

	private static int count;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;

		System.out.println(solution(numbers, target));
	}

	private static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0);
		return count;
	}

	private static void dfs(int[] numbers, int target, int k) {
		if (numbers.length == k) {
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum = sum + numbers[i];
			}
			if (sum == target) {
				count++;
			}
			return;
		}
		numbers[k] = numbers[k];
		dfs(numbers, target, k + 1);

		numbers[k] = -numbers[k];
		dfs(numbers, target, k + 1);
	}
}
