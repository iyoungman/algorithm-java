package binary_search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-16.
 * https://www.acmicpc.net/problem/1654
 * first + last 할 때 범위에 주의
 */

public class BOJ_1654_랜선자르기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        long[] lengths = new long[k];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lengths[i] = scanner.nextInt();
            max = Math.max(max, lengths[i]);
        }

        System.out.println(getMaxLength(lengths, n, max));
    }

    private static long getMaxLength(long[] lengths, int n, long max) {
        long first = 1;
        long last = max;
        long mid = 0;//랜선 길이
        long result = 0;

        while (first <= last) {
            mid = (first + last) / 2;
            boolean isPossible = isPossibleCount(lengths, mid, n);
            if (isPossible) {
                first = mid + 1;
                result = Math.max(result, mid);
            } else {//만들 수 있는게 적으므로 랜선 길이를 줄여야한다
                last = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossibleCount(long[] lengths, long mid, int n) {
        long count = 0;
        for (long length : lengths) {
            count = count + (length / mid);
        }

        return (int)count >= n;
    }
}
