package datastructure.tree;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-28.
 * https://www.acmicpc.net/problem/3653
 * 세그먼트 트리로 풀어야 시간초과가 안 나온다
 */

public class BOJ_3653_영화수집 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();//영화의 수
            int m = scanner.nextInt();//보려고 하는 영화 수
            int[] nums = new int[m];
            for (int k = 0; k < m; k++) {
                nums[k] = scanner.nextInt();
            }

            int[] up = new int[n + 1];
            for (int k = 1; k <= n; k++) {
                up[k] = k - 1;
            }

            int[] result = new int[m];
            for (int j = 0; j < m; j++) {
                int num = nums[j];
                int upCount = up[num];
                result[j] = upCount;

                for (int k = 1; k < up.length; k++) {
                    if (k == num) {
                        up[k] = 0;
                    } else {
                        if (up[k] < upCount) {//Count 가 큰것은 더 밑에 있는 것이므로 고려할 필요 없다
                            up[k] = up[k] + 1;
                        }
                    }
                }
            }

            //결과 출력
            for (int j = 0; j < m; j++) {
                System.out.print(result[j] + " ");
            }
        }
    }
}
