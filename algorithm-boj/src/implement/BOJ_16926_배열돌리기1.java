package implement;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-06.
 * https://www.acmicpc.net/problem/16926
 * 각 원소를 반시계 방향 회전
 * 시계 방향으로 돌면서 저장한다
 */

public class BOJ_16926_배열돌리기1 {

    private static int[][] map;
    private static boolean[][] visit;
    private static int n, m, r;
    private static int[] moveX = {0, 1, 0, -1};//우, 하, 좌, 상
    private static int[] moveY = {1, 0, -1, 0};//우, 하, 좌, 상

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//배열 크기
        m = scanner.nextInt();//배열 크기
        r = scanner.nextInt();//수행 회전 수
        map = new int[n][m];
        visit = new boolean[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        //회전수 만큼 반복
        for (int i = 0; i < r; i++) {
            int squareCount = getSquareCount(Math.min(n, m));
            rotate(squareCount);
        }

        //결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 짧은 변의 길이 / 2
     * 테두리 사각형 개수
     */
    private static int getSquareCount(int min) {
        return min / 2;
    }

    /**
     * 반시계 방향으로 1회전
     */
    private static void rotate(int squareCount) {
        for (int i = 0; i < squareCount; i++) {
            int val = map[i][i];//각 테두리의 첫 원소 저장
            int x = i;//시작x
            int y = i;//시작y
            int dir = 0;
            int cnt = 0;

            while (cnt < 4) {
                int nextX = x + moveX[dir];
                int nextY = y + moveY[dir];

                if (isInOfSquare(nextX, nextY, i)) {
                    map[x][y] = map[nextX][nextY];
                    x = nextX;
                    y = nextY;
                } else {//범위를 넘었을 때는 nextX, nextY를 저장 안 하므로 괜찮다
                    dir = (dir + 1) % 4;
                    cnt++;
                }
            }
            map[i + 1][i] = val;
        }
    }

    /**
     * 테두리 범위 안에 있는지 확인
     * 테두리 범위 안에 없으면 방향을 바꿔야한다
     */
    private static boolean isInOfSquare(int r, int c, int num) {
        return r >= num && c >= num && r < n - num && c < m - num;
    }

}
