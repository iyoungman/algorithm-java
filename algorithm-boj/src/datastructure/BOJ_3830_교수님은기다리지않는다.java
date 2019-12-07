package datastructure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-29.
 * https://www.acmicpc.net/problem/3830
 * 3 -> 2 -> 1 엮여서 이동하는 것 고려
 * 트리? 그래프?
 */

public class BOJ_3830_교수님은기다리지않는다 {

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();//샘플의 수
            int m = scanner.nextInt();//일의 수
            scanner.nextLine();
            if (n == 0 && m == 0) {
                break;
            }

            int[][] difference = new int[n][n];
            for (int[] line : difference) {
                Arrays.fill(line, 10000001);
            }

            for (int i = 0; i < m; i++) {
                String[] line = scanner.nextLine().split(" ");
                if (line.length == 4) {
                    int a = stoi(line[1]);
                    int b = stoi(line[2]);
                    int sub = stoi(line[3]);
                    difference[b - 1][a - 1] = sub;
                    difference[a - 1][b - 1] = -sub;
                } else {
                    int a = stoi(line[1]);
                    int b = stoi(line[2]);
                    if (difference[b - 1][a - 1] == 10000001) {
                        System.out.println("UNKNOWN");
                    } else {
                        System.out.println(difference[b - 1][a - 1]);
                    }
                }
            }


        }
    }

    private static void question(int a, int b) {

    }
}
