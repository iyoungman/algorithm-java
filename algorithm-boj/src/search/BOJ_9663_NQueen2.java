package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-06.
 * https://www.acmicpc.net/problem/9663
 * http://sooyoung32.github.io/dev/2016/03/14/n-queen-algorithm.html
 * 2차원 배열 체크를 1차원 배열로 바꿔 시간초과를 방지
 */

public class BOJ_9663_NQueen2 {

    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] temp = new int[n];
        dfs(temp, 0);
        System.out.println(count);
    }

    private static void dfs(int[] temp, int depth) {
        int N = temp.length;

        if (depth == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {//열을 돌면서
                temp[depth] = i;//temp 의 인덱스는 행이다
                if (isPromising(temp, depth))
                    dfs(temp, depth + 1);// 유망하다면 계속 탐색(재귀호출)
            }
        }
    }

    private static boolean isPromising(int[] temp, int currentDepth) {
        for (int i = 0; i < currentDepth; i++) {
            if (temp[i] == temp[currentDepth]) return false;// 같은 열이 있는지 학인
            if ((temp[i] - temp[currentDepth]) == (currentDepth - i)) return false;// '\' 방향
            if ((temp[currentDepth] - temp[i]) == (currentDepth - i)) return false;// '/' 방향
        }
        return true;
    }
}
