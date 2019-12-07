package dp;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-23.
 * https://www.acmicpc.net/problem/11052
 * 어려운 식..
 */

public class BOJ_11052_카드구매하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//카드 개수
        int[] price = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            price[i] = scanner.nextInt();
        }

        //BottomUP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + price[j]);
            }
        }

        //결과 출력
        System.out.println(d[n]);
    }
}
