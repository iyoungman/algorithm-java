package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-28.
 * https://www.acmicpc.net/problem/9663
 * 풀이 1. 체크시마다 이차원 배열을 건냈다 -> 시간초과
 */

public class BOJ_9663_NQueen {

    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[][] visit = new boolean[n][n];

        for (int i = 0; i < visit[0].length; i++) {
            visit[0][i] = true;
            dfs(0, n, visit);
            visit[0][i] = false;
        }

        //결과 출력
        System.out.println(count);
    }

    private static void dfs(int depth, int n, boolean[][] visit) {
        if (depth == n - 1) {
            count++;
            return;
        }

        //다음 깊이 탐색
        for (int j = 0; j < n; j++) {
            if (isPossible(depth + 1, j, visit)) {
                visit[depth + 1][j] = true;
                dfs(depth + 1, n, visit);
                visit[depth + 1][j] = false;
            }
        }
    }

    private static boolean isPossible(int i, int j, boolean[][] visit) {
        for (int k = 0; k < visit.length; k++) {
            for (int kk = 0; kk < visit[0].length; kk++) {
                if (visit[k][kk] && (k == i || kk == j)) {
                    return false;
                }
                if (visit[k][kk] && Math.abs(i - k) == Math.abs(j - kk)) {//대각선 체크
                    return false;
                }
            }
        }
        return true;
    }

}
