package contest.ucpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-18.
 * https://www.acmicpc.net/problem/17364
 */

public class BOJ_17364_대회 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//대회수
        int k = scanner.nextInt();//등수
        int[][] dates = new int[n][2];

        for (int i = 0; i < n; i++) {
            dates[i][0] = scanner.nextInt();//시작 날짜
            dates[i][1] = scanner.nextInt();//종료 날짜
        }

        //정렬
        Arrays.sort(dates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

    }

    private static boolean isOverlapPeriod(int end, int start) {
        return end >= start;//겹치는 경우
    }
}
