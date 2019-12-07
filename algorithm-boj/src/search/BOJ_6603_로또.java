package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-28.
 * https://www.acmicpc.net/problem/6603
 * 백트래킹 https://heekim0719.tistory.com/284
 */

public class BOJ_6603_로또 {

    private static int n;
    private static int[] nums;
    private static int[] result;//nums의 각 위치

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            nums = new int[n];
            result = new int[n];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            print();
        }
        for (int i = start; i < n; i++) {
            result[i] = 1;
            dfs(i + 1, depth + 1);//가지치기
            result[i] = 0;//돌아온다
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            if (result[i] == 1)
                System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
