package datastructure.map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-21.
 * https://www.acmicpc.net/problem/10816
 * https://wootool.tistory.com/63
 */

public class BOJ_10816_숫자카드2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> cardMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cardNum = scanner.nextInt();
            if (cardMap.containsKey(cardNum)) {
                cardMap.put(cardNum, cardMap.get(cardNum) + 1);
            } else {
                cardMap.put(cardNum, 1);
            }
        }

        int m = scanner.nextInt();
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int input = scanner.nextInt();
            result[i] = cardMap.getOrDefault(input, 0);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
