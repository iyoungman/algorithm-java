package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-27.
 * https://www.acmicpc.net/problem/1057
 */

public class BOJ_1057_토너먼트 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//참가자 수
        int jiminNum = scanner.nextInt();
        int hansuNum = scanner.nextInt();
        int count = 0;

        while (true) {
            count++;
            if (check(jiminNum, hansuNum)) {
                break;
            }
            jiminNum = nextNum(jiminNum);
            hansuNum = nextNum(hansuNum);
        }

        //결과 출력
        System.out.println(count);
    }

    private static boolean check(int jiminNum, int hansuNum) {
        int small = Math.min(jiminNum, hansuNum);
        int big = Math.max(jiminNum, hansuNum);

        if (small % 2 == 1 && small + 1 == big) {
            return true;
        }
        return false;
    }

    private static int nextNum(int num) {
        return (num % 2 == 1) ? num / 2 + 1 : num / 2;
    }
}
