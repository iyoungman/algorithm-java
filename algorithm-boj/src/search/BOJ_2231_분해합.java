package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-09.
 * https://www.acmicpc.net/problem/2231
 */

public class BOJ_2231_분해합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = 0;
        for (int i = 1; i < n; i++) {
            if (getNum(i) == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int getNum(int i) {
        int ressult = i;
        while (true) {
            ressult = ressult + (i % 10);
            i = i / 10;
            if(i == 0) break;
        }

        return ressult;
    }
}
