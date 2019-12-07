package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-21.
 * https://www.acmicpc.net/problem/14503
 */

public class BOJ_14503_로봇청소기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//세로
        int m = scanner.nextInt();//가로
        int r = scanner.nextInt();//좌표
        int c = scanner.nextInt();//좌표
        int dir = scanner.nextInt();//방향
        int[][] graph = new int[n][m];
        int result = 0;

        //좌표 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        while (true) {

        }
    }
}
