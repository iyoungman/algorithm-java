package binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-14.
 * https://www.acmicpc.net/problem/2110
 * 조건의 개수에 맞추면서 가장 인접한 두 공유기 사이를 최대로 하는 값
 */

public class BOJ_2110_공유기설치 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] internetModem = new int[n];

        for (int i = 0; i < n; i++) {
            internetModem[i] = scanner.nextInt();
        }
        Arrays.sort(internetModem);

        System.out.println(integerBinarySearch(internetModem, n, c));
    }

    private static int integerBinarySearch(int[] arr, int size, int count) {
        int first = 1;
        int last = arr[size - 1] - arr[0];
        int mid = 0;
        int result = 0;

        while (first <= last) {
            mid = (first + last) / 2;
            if (isPossible(arr, mid, count)) {//공유기가 목표 이상이면
                result = Math.max(result, mid);
                first = mid + 1;
            } else {//공유기가 모자라면
                last = mid - 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int value, int count) {
        int result = 1;
        int before = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - before >= value) {
                result++;
                before = arr[i];
            }
        }
        return result >= count;
    }
}
