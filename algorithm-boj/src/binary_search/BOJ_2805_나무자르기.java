package binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-19.
 * https://www.acmicpc.net/problem/2805
 */

public class BOJ_2805_나무자르기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//나무의 수
        int m = scanner.nextInt();//필요로 하는 길이

        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }

        Arrays.sort(tree);
        System.out.println(getMax(m, tree));
    }

    private static int getMax(int m, int[] tree) {
        int left = 1;
        int right = tree[tree.length - 1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int index : tree) {
                if (mid < index) {
                    sum = sum + (index - mid);
                }
            }

            if (sum > m) {//나무를 자르는 높이를 더 높여본다
                left = mid + 1;
                result = mid;
            } else if (sum < m) {//더 필요하므로 높이를 낮춘다
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return result;
    }
}
