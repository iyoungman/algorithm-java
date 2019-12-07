package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-05.
 * https://www.acmicpc.net/problem/1476
 */

public class BOJ_1476_날짜계산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int year = 1;
        int ee = 0, ss = 0, mm = 0;
        while (true) {
            ee = year % 15 == 0 ? 15 : year % 15;
            ss = year % 28 == 0 ? 28 : year % 28;
            mm = year % 19 == 0 ? 19 : year % 19;

            if (ee == e && ss == s && mm == m) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }

}
