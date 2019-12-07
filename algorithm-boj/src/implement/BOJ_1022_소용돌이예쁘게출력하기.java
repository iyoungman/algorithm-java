package implement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-02.
 * https://www.acmicpc.net/problem/1022
 * 가장 큰 절대값으로 풀면 메모리 초과난다, 조건에 맞게 범위를 맞춰줄것
 */

public class BOJ_1022_소용돌이예쁘게출력하기 {

    private static int[][] moveXY = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};//우상좌하

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt();//왼쪽 행
        int c1 = scanner.nextInt();//위쪽 열
        int r2 = scanner.nextInt();//아래쪽 행
        int c2 = scanner.nextInt();//오른쪽 열

        int row = Math.max(Math.abs(r1), Math.abs(r2)) * 2 + 1;
        int column = Math.max(Math.abs(c1), Math.abs(c2)) * 2 + 1;
        int[][] graph = new int[row][column];

        for (int i = 0; i < row; i++) {
            Arrays.fill(graph[i], -10);
        }

        int tempX = row / 2;
        int tempY = column / 2;
        graph[tempX][tempY] = 1;
        int current = -1;
        for (int i = 2; i <= row * column; i++) {
            current = getNext(current);

            if (graph[tempX + moveXY[current][0]][tempY + moveXY[current][1]] != -10) {//이미 차있으면
                current = getMore(current);
            }
            tempX = tempX + moveXY[current][0];
            tempY = tempY + moveXY[current][1];
            graph[tempX][tempY] = i;
        }

        int maxLength = Integer.toString(graph[tempX][tempY]).length();
        for (int i = r1 + row / 2; i <= r2 + row / 2; i++) {
            for (int j = c1 + column / 2; j <= c2 + column / 2; j++) {
                int currentLength = Integer.toString(graph[i][j]).length();
                if (maxLength - currentLength > 0) {
                    for (int k = 1; k <= maxLength - currentLength; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getNext(int current) {
        return current == 3 ? 0 : current + 1;
    }

    private static int getMore(int current) {
        return current == 0 ? 3 : current - 1;//상->우, 하->좌, 우 -> 하, 좌 -> 상
    }
}
