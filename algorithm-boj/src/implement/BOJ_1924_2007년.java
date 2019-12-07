package implement;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-30.
 * https://www.acmicpc.net/problem/1924
 */

public class BOJ_1924_2007년 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfTheWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int day = 0;
        if (x == 1) {
            day = y;
        } else {
            for (int i = 0; i < x - 1; i++) {
                day = day + days[i];
            }
            day = day + y;
        }

        int remain = day % 7;
        if (remain == 0) {
            System.out.println(dayOfTheWeek[6]);
        } else {
            System.out.println(dayOfTheWeek[remain - 1]);
        }
    }
}
