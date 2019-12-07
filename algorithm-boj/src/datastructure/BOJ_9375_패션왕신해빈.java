package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-28.
 * https://www.acmicpc.net/problem/9375
 * 각 종류마다 입지 않는 경우의 수도 있으므로 + 1, 마지막에 모두 안 입는 경우 -1
 */

public class BOJ_9375_패션왕신해빈 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();//의상의 종류
            scanner.nextLine();
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] line = scanner.nextLine().split(" ");
                String name = line[0];
                String kind = line[1];

                if (map.containsKey(kind)) {
                    int current = map.get(kind);
                    map.put(kind, ++current);
                } else {
                    map.put(kind, 1);
                }
            }

            int result = 1;
            for (String key : map.keySet()) {
                result = result * (map.get(key) + 1);
            }

            //결과 출력
            System.out.println(result - 1);
        }
    }
}
