package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-04.
 * https://www.acmicpc.net/problem/1987
 * DFS 이므로 원래는 Visit 가 당연히 필요하다
 * 다만 AlphabetCheck 하는 부분이 코드상으로 Visit 의 역할을 하고있다
 */

public class BOJ_1987_알파벳 {

    private static int max = 1;
    private static int R;
    private static int C;
    private static char[][] boards;
    private static boolean[] alphabetCheck = new boolean[26];

    private static int[] xMove = {0, 0, -1, 1};//순서대로 상하좌우
    private static int[] yMove = {-1, 1, 0, 0};//순서대로 상하좌우

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();

        boards = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < C; j++) {
                boards[i][j] = s.charAt(j);
            }
        }

        alphabetCheck[boards[0][0] - 65] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int i, int j, int count) {
        max = Math.max(max, count);

        for (int k = 0; k < 4; k++) {
            int nextX = i + xMove[k];
            int nextY = j + yMove[k];

            if (!checkArrayIndexOut(nextX, nextY)) {
                int next = (int) boards[nextX][nextY] - 65;
                if (!alphabetCheck[next]) {
                    alphabetCheck[next] = true;
                    dfs(nextX, nextY, count + 1);//갈때까지 들어간다음
                    alphabetCheck[next] = false;//나오면서 false를 해준다
                }
            }
        }
    }

    private static boolean checkArrayIndexOut(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }
}
