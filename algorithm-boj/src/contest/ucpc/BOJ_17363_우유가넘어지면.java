package contest.ucpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-18.
 * https://www.acmicpc.net/problem/17363
 */

public class BOJ_17363_우유가넘어지면 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//세로 길이
        int m = scanner.nextInt();//가로 길이
        scanner.nextLine();
        char[][] draw = new char[m][n];

        init();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                draw[m - 1 - j][i] = rotation(c);
            }
        }

        //결과 출력
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(draw[i][j]);
            }
            System.out.println();
        }
    }

    private static void init() {
        map.put(46, 46);
        map.put(79, 79);
        map.put(45, 124);
        map.put(124, 45);
        map.put(47, 92);
        map.put(92, 47);
        map.put(94, 60);
        map.put(60, 118);
        map.put(118, 62);
        map.put(62, 94);
    }

    private static char rotation(char c) {
        int key = (int) c;
        int value = map.get(key);
        return (char) value;
    }
}
