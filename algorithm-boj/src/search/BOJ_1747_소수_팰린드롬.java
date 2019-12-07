package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-04.
 * https://www.acmicpc.net/problem/1747
 */

public class BOJ_1747_소수_팰린드롬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = 0;
        boolean[] isPrime = isPrime(2000001);
        while (true) {
            n = n + 1;
            if (isPrime[n] && isPellindeurom(n)) {
                result = n;
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean[] isPrime(int end) {
        boolean[] isPrime = new boolean[end + 1];

        //모두 소수로 셋팅
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        //소수가 아닌 것을 거른다
        for (int i = 2; i <= end; i++) {
            for (int j = 2; i * j <= end; j++) {//특정 수의 배수를 제거한다
                isPrime[i * j] = false;
            }
        }

        return isPrime;
    }

    private static boolean isPellindeurom(int n) {
        String origin = String.valueOf(n);
        StringBuilder reverse = new StringBuilder();

        for (int i = origin.length() - 1; i >= 0; i--) {
            reverse.append(origin.charAt(i));
        }

        return origin.equals(reverse.toString());
    }
}
