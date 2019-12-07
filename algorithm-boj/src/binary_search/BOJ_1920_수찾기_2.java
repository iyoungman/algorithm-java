package binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-31.
 * https://www.acmicpc.net/problem/1920
 */

public class BOJ_1920_수찾기_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        int m = scanner.nextInt();
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int input = scanner.nextInt();
            result[i] = binarySearch(nums, input);
        }

        //결과 출력
        for (int value : result) {
            System.out.println(value);
        }
    }

    private static int binarySearch(int[] nums, int input) {
        int first = 0;
        int last = nums.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;
            if (input == nums[mid]) {
                return 1;
            } else if (input < nums[mid]) {
                last = mid - 1;
            } else {//input > nums[mid]
                first = mid + 1;
            }
        }

        return 0;
    }
}
