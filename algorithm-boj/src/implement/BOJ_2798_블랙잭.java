package implement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-23.
 * https://www.acmicpc.net/problem/2798
 */

public class BOJ_2798_블랙잭 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//카드의 개수
        int m = scanner.nextInt();//숫자
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if(temp > m) {
                        break;
                    }
                    result = Math.max(result, temp);
                }
            }
        }

        //결과 출력
        System.out.println(result);
    }
}
