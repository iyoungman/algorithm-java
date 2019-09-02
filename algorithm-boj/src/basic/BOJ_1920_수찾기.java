package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-31.
 * https://www.acmicpc.net/problem/1920
 */

public class BOJ_1920_수찾기 {

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
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                if (input == nums[j]) {
                    result[i] = 1;
                    break;
                }
            }
        }

        //결과 출력
        for (int value : result) {
            System.out.println(value);
        }
    }
}
