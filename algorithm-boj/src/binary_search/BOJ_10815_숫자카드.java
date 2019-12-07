package binary_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-
 * https://www.acmicpc.net/problem/10815
 * 그냥 반복문 돌려도 된다
 * 하지만 범위가 크다면 시간초과를 대비해 이분 탐색하자
 */

public class BOJ_10815_숫자카드 {

    private static int[] cards;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(cards);
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = isExist(nums[i], cards);
        }

        //결과 출력
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    private static int isExist(int m, int[] cards) {
        int left = 0;
        int right = cards.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (cards[mid] > m) {
                right = mid - 1;
            } else if (cards[mid] < m) {
                left = mid + 1;
            } else {
                return 1;
            }
        }

        //없으면
        return 0;
    }
}
