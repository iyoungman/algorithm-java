package simulation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-25.
 * https://www.acmicpc.net/problem/3190
 */

public class BOJ_3190_뱀 {

    private static int[] moveX = {0, 1, 0, -1};//우하좌상
    private static int[] moveY = {1, 0, -1, 0};//우하좌상
    private static int dir = 0;//0, 1, 2, 3
    private static ArrayList<Integer> x;
    private static ArrayList<Integer> y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//보드의 크기
        int k = scanner.nextInt();//사과의 개수
        boolean[][] board = new boolean[n][n];//보드

        for (int i = 0; i < k; i++) {
            int row = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;
            board[row][column] = true;
        }

        int l = scanner.nextInt();//방향 변환 횟수
        int[][] directions = new int[l][2];
        for (int i = 0; i < l; i++) {
            directions[i][0] = scanner.nextInt();
            directions[i][1] = (int) (scanner.next().charAt(0));
        }

        int time = 0;//시간
        int temp = 0;
        x = new ArrayList<Integer>(); y = new ArrayList<Integer>();
        x.add(0);y.add(0);

        while (true) {
            time++;
            if (!getMoveMatrix() || isOut(n)) {//자기 자신과 부딪치거나 범위 내에 없다면
                break;
            }

            if (board[x.get(0)][y.get(0)]) {
                int xBefore = x.get(0) - moveX[dir];
                int yBefore = y.get(0) - moveY[dir];
                x.add(xBefore);
                y.add(yBefore);
            }

            if (temp < directions.length && time == directions[temp][0]) {
                char c = (char) directions[temp][1];
                if (c == 'D') {
                    dir = (++dir) % 4;
                } else {
                    dir--;
                    dir = (dir == -1) ? 3 : dir;
                }
                temp++;
            }
        }

        //결과 출력
        System.out.println(time);
    }

    private static boolean getMoveMatrix() {
        //Check
        int afterX = x.get(0) + moveX[dir];
        int afterY = y.get(0) + moveY[dir];
        if(x.contains(afterX) && y.contains(afterY)) {
            return false;
        }

        int length = x.size();
        for (int i = 0; i < length; i++) {
            x.set(i, x.get(i) + moveX[dir]);
            y.set(i, y.get(i) + moveY[dir]);
        }
        return true;
    }

    private static boolean isOut(int n) {
        return x.get(0) >= n || x.get(0) < 0 || y.get(0) >= n || y.get(0) < 0;
    }
}
