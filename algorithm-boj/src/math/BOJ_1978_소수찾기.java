package math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-02.
 * https://www.acmicpc.net/problem/1978
 */

public class BOJ_1978_소수찾기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int max = Arrays.stream(nums)
                .max()
                .getAsInt();

        boolean[] isPrime = getPrime(max);

        //결과 출력
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[nums[i]]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean[] getPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];//max까지 저장

        //모두 소수로 셋팅
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        //소수가 아닌 것을 거른다
        for (int i = 2; i <= max; i++) {
            for (int j = 2; i * j <= max; j++) {//특정 수의 배수를 제거한다
                isPrime[i * j] = false;
            }
        }

        return isPrime;
    }

}
