package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-22.
 * https://www.acmicpc.net/problem/1021
 */

public class BOJ_1021_회전하는큐 {
    private static int n;//큐의 크기
    private static int m;//뽑아내는 수 개수
    private static boolean[] isExist;//이미 추출한 것 체크

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isExist = new boolean[n];
        int count = 0;
        int current = 0;

        for (int i = 0; i < m; i++) {
            int extract = scanner.nextInt() - 1;//현재 뽑는 수
            count = count + Math.min(moveLeft(current, extract), moveRight(current, extract));
            isExist[extract] = true;
            if (i != m - 1) {
                current = getNext(extract);
            }
        }

        //결과 출력
        System.out.println(count);
    }

    private static int moveLeft(int current, int extract) {
        int count = 0;

        while (current != extract) {
            current = (current - 1 < 0) ? n - 1 : current - 1;

            if (!isExist[current]) {
                count++;
            }
        }

        return count;
    }

    private static int moveRight(int current, int extract) {
        int count = 0;

        while (current != extract) {
            current = (current + 1 >= n) ? 0 : current + 1;

            if (!isExist[current]) {
                count++;
            }
        }

        return count;
    }

    private static int getNext(int current) {

        while (true) {
            current = (current + 1 >= n) ? 0 : current + 1;
            if (!isExist[current]) {
                break;
            }
        }
        return current;
    }
}
