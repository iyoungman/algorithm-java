package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-09.
 * https://www.acmicpc.net/problem/10819
 * 완전탐색 중 순열을 이용한 방법
 */

public class BOJ_10819_차이를최대로 {

    private static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        perm(nums, 0, n);
        System.out.println(max);
    }

    private static void perm(int[] nums, int depth, int n) {
        if (depth == n) {
            sum(nums, n);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(nums, i, depth);
            perm(nums, depth + 1, n);
            swap(nums, i, depth);
        }
    }

    private static void swap(int[] nums, int depth, int n) {
        int temp = nums[depth];
        nums[depth] = nums[n];
        nums[n] = temp;
    }

    private static void sum(int[] nums, int k) {
        int sum = 0;
        for (int i = 2; i <= k; i++) {
            sum += Math.abs(nums[i - 2] - nums[i - 1]);
        }
        if (max < sum) {
            max = sum;
        }
    }
}
