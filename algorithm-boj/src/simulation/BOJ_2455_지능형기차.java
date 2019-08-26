package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-26.
 * https://www.acmicpc.net/problem/2455
 */

public class BOJ_2455_지능형기차 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;

        for (int i = 0; i < 4; i++) {
            int difference = scanner.nextInt() - scanner.nextInt();
            max = Math.max(max, max + difference);
        }

        //결과 출력
        System.out.println(max);
    }
}
