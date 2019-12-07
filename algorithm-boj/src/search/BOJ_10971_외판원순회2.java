package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-10.
 * https://www.acmicpc.net/problem/10971
 * 순열이다
 */

public class BOJ_10971_외판원순회2 {

    private static int min = Integer.MAX_VALUE;
    private static int[][] costs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        costs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        permutationAll(nums, 0, n);
        System.out.println(min);
    }

    private static void permutationAll(int[] nums, int depth, int n) {
        if (depth == n) {
            //할일
            print(nums);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(nums, depth, i);
            permutationAll(nums, depth + 1, n);
            swap(nums, depth, i);
        }
    }

    private static void swap(int[] nums, int depth, int i) {
        int temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }

    private static void print(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int end = (i == nums.length - 1) ? nums[0] : nums[i + 1];

            int cost = costs[start][end];
            if (cost == 0) {//가는길이 없다면
                return;
            } else {
                sum += cost;
            }
        }

        min = Math.min(min, sum);
    }
}
