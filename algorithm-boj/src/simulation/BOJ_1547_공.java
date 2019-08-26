package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-25.
 * https://www.acmicpc.net/problem/1547
 */

public class BOJ_1547_공 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//횟수
        int current = 1;

        for (int i = 0; i < m; i++) {
            int one = scanner.nextInt();
            int two = scanner.nextInt();

            if (one == current) {
                current = two;
            } else if (two == current) {
                current = one;
            }
        }

        //결과 출력
        System.out.println(current);
    }
}
