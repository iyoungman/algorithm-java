package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-02.
 * https://www.acmicpc.net/problem/1929
 * 에라토스테네스의 체는 잘 알아둘 것
 */

public class BOJ_1929_소수구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//시작
        int n = scanner.nextInt();//끝
        boolean[] isPrime = new boolean[n + 1];//n까지 저장

        //모두 소수로 셋팅
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        //소수가 아닌 것을 거른다
        for (int i = 2; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {//특정 수의 배수를 제거한다
                isPrime[i * j] = false;
            }
        }

        //결과 출력
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
