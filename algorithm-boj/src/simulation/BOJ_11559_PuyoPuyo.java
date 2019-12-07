package simulation;

import java.util.*;

/**
 * Created by YoungMan on 2019-08-26.
 * https://www.acmicpc.net/problem/11559
 */

public class BOJ_11559_PuyoPuyo {

    private static char[][] chars = new char[12][6];
    private static boolean[][] visit = new boolean[12][6];
    private static int[] xMove = {0, 0, -1, 1};//상하좌우
    private static int[] yMove = {-1, 1, 0, 0};//상하좌우
    private static int cnt;

    private static ArrayList<Temp> temp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        for (int i = 0; i < 12; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 6; j++) {
                chars[i][j] = line.charAt(j);
            }
        }

        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                char c = chars[i][j];
                if (isPuyo(c) && !visit[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    if (cnt >= 4) {
                        result++;
                        relocation();
                    }
                }
            }
        }

        //결과 출력
        System.out.println(result);
    }

    private static boolean isPuyo(char c) {
        return c == 'R' || c == 'G' || c == 'B' || c == 'P' || c == 'Y';
    }

    private static void dfs(int x, int y) {
        cnt++;
        visit[x][y] = true;
        temp.add(new Temp(x, y));

        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (!checkArrayIndexOut(nextX, nextY) && !visit[nextX][nextY] && chars[x][y] == chars[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }

    private static boolean checkArrayIndexOut(int x, int y) {
        return x < 0 || x >= chars.length || y < 0 || y >= chars[11].length;
    }

    private static void relocation() {
        Collections.sort(temp, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });

        int count = 1;
        for (int i = 1; i < temp.size(); i++) {
            visit[temp.get(i).x][temp.get(i).y] = false;
            if (temp.get(i).y == temp.get(i - 1).y) {
                count++;
                if (i == temp.size() - 1) {//마지막 원소일떄
                    int column = temp.get(i - 1).y;
                    for (int k = 11; k >= 0; k--) {
                        if (k - count > 0) {
                            chars[k][column] = chars[k - count][column];
                        } else {
                            chars[k][column] = '.';
                        }
                    }
                }
            } else {
                int column = temp.get(i - 1).y;
                for (int k = 11; k >= 0; k--) {
                    if (k - count > 0) {
                        chars[k][column] = chars[k - count][column];
                    } else {
                        chars[k][column] = '.';
                    }
                }
                count = 1;
            }
        }

        //초기화
        temp = new ArrayList<>();
    }


}

class Temp {
    int x;
    int y;

    public Temp(int x, int y) {
        this.x = x;
        this.y = y;
    }
}