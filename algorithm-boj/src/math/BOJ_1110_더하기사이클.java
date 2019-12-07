package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-19.
 * https://www.acmicpc.net/problem/1110
 */

public class BOJ_1110_더하기사이클 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int given = n;
        int count = 0;

        while (true) {
            given = getNext(given);
            count++;
            if (n == given) {
                break;
            }
        }

        System.out.println(count);
    }

    private static int getNext(int n) {
        int given = n % 10;//주어진 수의 오른쪽 자리수
        int mok = n / 10;
        int sum = (mok + given >= 10) ? (mok + given) % 10 : mok + given;

        return given * 10 + sum;
    }
}
