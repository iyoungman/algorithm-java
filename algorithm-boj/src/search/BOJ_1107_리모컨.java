package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-05.
 * https://www.acmicpc.net/problem/1107
 * 조합 없이 노가다로 풀어도 된다
 */

public class BOJ_1107_리모컨 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//채널
        int m = scanner.nextInt();//제외 버튼
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int input = scanner.nextInt();
            list.add(input);
        }

        if (n == 100) {
            min = 0;
            System.out.println(min);
            return;
        }

        for (int i = 0; i < 900000; i++) {
            if (isPossibleMove(i, list)) {
                int size = (i == 0) ? 1 : (int)(Math.log10(i)+1);
                if (i == n) {
                    min = size;
                } else {
                    min = Math.min(min, Math.abs(n - i) + size);
                }
            }
        }

        min = Math.min(min, Math.abs(n - 100));//100에서 바로 이동하는 경우

        System.out.println(min);
    }

    private static boolean isPossibleMove(int i, ArrayList<Integer> list) {
        String s = String.valueOf(i);
        char[] array = s.toCharArray();

        for (char c : array) {
            if (list.contains(c - '0')) {
                return false;
            }
        }

        return true;
    }

}
