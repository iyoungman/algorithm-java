package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-01.
 * https://www.acmicpc.net/problem/14501
 */

public class BOJ_14501_퇴사 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] d = new int[n];
        int[][] counseling = new int[n][2];

        for (int i = 0; i < n; i++) {
            counseling[i][0] = scanner.nextInt();
            counseling[i][1] = scanner.nextInt();
        }

        //BottomUp
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int deadline = i + 1;
//            int temp = 0;
//            for (int j = 0; j <= i; j++) {
//                temp = temp +
//            }
//        }
    }
}
