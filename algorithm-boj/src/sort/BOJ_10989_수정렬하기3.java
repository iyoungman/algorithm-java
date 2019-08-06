package sort;

import java.util.*;

/**
 * Created by YoungMan on 2019-05-01.
 * https://www.acmicpc.net/problem/10989
 */

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];

		//입력
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		//정렬
		Arrays.sort(nums);

		for (int i : nums) {
			System.out.println(i);
		}
	}
}
