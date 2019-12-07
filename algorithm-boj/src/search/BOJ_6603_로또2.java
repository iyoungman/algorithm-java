package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-10.
 * https://www.acmicpc.net/problem/6603
 * nCr 후 오름차순
 */

public class BOJ_6603_로또2 {

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

            combination(combNums, n, 6, 0, 0, nums);
            System.out.println();
        }
    }

    private static void combination(int[] combNums, int n, int r, int index, int target, int[] nums) {
        if (r == 0) {//뽑을 것 뽑았으면
            print(combNums, nums);
            return;
        }
        if (target == n)//검사가 끝난 경우
            return;

        combNums[index] = target;
        combination(combNums, n, r - 1, index + 1, target + 1, nums);//뽑는경우
        combination(combNums, n, r, index, target + 1, nums);//안뽑는경우
    }

    private static void print(int[] combNums, int[] nums) {
        Arrays.sort(combNums);
        for (int index : combNums) {
            System.out.print(nums[index] + " ");
        }
        System.out.println();
    }
}
