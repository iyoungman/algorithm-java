package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-12-02.
 * https://www.acmicpc.net/problem/14501
 * 상담날짜를 1씩 증가시키는 것이 아니라 상당날짜대로 증가시키면 된다
 */

public class BOJ_14501_퇴사 {

	private static int max;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] nums = new int[n][2];

		for (int i = 0; i < n; i++) {
			nums[i][0] = scanner.nextInt();//
			nums[i][1] = scanner.nextInt();//
		}

		dfs(0, 0, nums);
		System.out.println(max);
	}

	/**
	 * 중요한 건
	 * cost를 저장하지 않고 넘기기만 한다
	 */
	private static void dfs(int index, int cost, int[][] nums) {
		if (index == nums.length) {//모든 경우를 다 탐색한 경우
			max = Math.max(cost, max);
			return;
		}

		if (index > nums.length) {
			return;
		}

		//뽑은 경우
		dfs(index + nums[index][0], cost + nums[index][1], nums);

		//안 뽑은 경우
		dfs(index + 1, cost, nums);
	}
}
