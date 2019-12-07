package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-26.
 * https://www.acmicpc.net/problem/2512
 * 상한액을 하나씩 탐색하지 말고 이분탐색
 */

public class BOJ_2512_예산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fee = new int[n];
        for (int i = 0; i < n; i++) {
            fee[i] = scanner.nextInt();
        }
        int allFee = scanner.nextInt();

        Arrays.sort(fee);
        if (getAllFee(fee) <= allFee) {
            System.out.println(fee[n - 1]);
            return;
        }

        System.out.println(getCeiling(fee, allFee));

    }

    private static int getAllFee(int[] fee) {
        int sum = 0;
        for (int i = 0; i < fee.length; i++) {
            sum = sum + fee[i];
        }

        return sum;
    }

    private static int getCeiling(int[] fee, int allFee) {
        int first = 0;
        int last = fee[fee.length - 1];
        int mid;//중간값

        int max = 0;
        while (first <= last) {
            mid = (first + last) / 2;//상한액

            int sum = 0;
            for (int i = 0; i < fee.length; i++) {
                if (fee[i] < mid) {
                    sum = sum + fee[i];
                } else {//초과
                    sum = sum + (mid * (fee.length - i));
                    break;
                }
            }

            if (sum <= allFee) {
                first = mid + 1;
                max = Math.max(max, mid);
            } else {
                last = mid - 1;
            }
        }
        return max;
    }

}
