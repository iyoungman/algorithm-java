package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-04.
 * https://www.acmicpc.net/problem/6603
 * 각 경우의 수를 오름차순으로 출력
 */

public class BOJ_6603_로또3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            int[] nums = new int[n];
            int[] combNums = new int[6];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }

            dfs(0, 0, nums, combNums);
            System.out.println();
        }
    }

    public static void dfs(int start, int depth, int[] nums, int[] combNums) {
        if (depth == 6) {
            print(combNums);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            combNums[depth] = nums[i];
            dfs(i + 1, depth + 1, nums, combNums);
        }
    }

    private static void print(int[] combNums) {
        for (int num : combNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
