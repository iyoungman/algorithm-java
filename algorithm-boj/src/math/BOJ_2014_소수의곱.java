package math;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-26.
 * https://www.acmicpc.net/problem/2014
 * 소수간의 곱보다는 각 소수의 배수를 구하면 쉽다
 * 2 * 3 , 3 * 2 중복 -> 나눠 떨어지는 값 까지만, 2는 2 * 2 까지 3은 3 * 2, 3 * 3 까지
 */

public class BOJ_2014_소수의곱 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();//k개의 소수
        int n = scanner.nextInt();//n번째 오는 것 출력
        int[] primes = new int[k];
        PriorityQueue<Integer> numsQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            primes[i] = scanner.nextInt();
            numsQueue.offer(primes[i]);
        }

        for (int i = 1; i < n; i++) {
            int top = numsQueue.poll();
            for (int j = 0; j < k; j++) {
                int push = top * primes[j];
                numsQueue.offer(push);

                if (top % primes[j] == 0) {//중복 제거를 위함
                    break;
                }
            }
        }

        System.out.println(numsQueue.poll());
    }
}
