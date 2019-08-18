package contest.ucpc;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-18.
 * https://www.acmicpc.net/problem/17362
 */

public class BOJ_17362_수학은체육과목입니다2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = (n <= 5) ? n : calculate(n);
        System.out.println(result);
    }

    private static int calculate(int n) {
        n = n - 6;

        int mok = n / 4;
        int remain = n % 4;
        if (mok % 2 == 0) {//4로 나눈 몫이 짝수인 경우
            return (4 - remain);
        } else {//4로 나눈 몫이 홀수인 경우
            return remain + 2;
        }
    }
}
