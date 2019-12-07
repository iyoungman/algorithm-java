package search;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-11.
 * https://www.acmicpc.net/problem/1963
 * BFS를 이용한 완전 탐색
 */

public class BOJ_1963_소수경로 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int before = scanner.nextInt();
            int after = scanner.nextInt();

            String result = bfs(before, after);
            System.out.println(result);
        }
    }

    private static String bfs(int before, int end) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.offer(before);
        int[] visit = new int[10000];
        visit[before] = 1;

        int temp = 0;
        boolean[] isPrimeResult = isPrime(1000, 9999);
        while (linkedList.size() != 0) {
            int front = linkedList.poll();
            StringBuilder numSb = new StringBuilder(String.valueOf(front));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) continue;
                    if (numSb.charAt(i) - '0' == j) continue;
                    temp = getNum(numSb, i, j);

                    if (isPrimeResult[temp] && visit[temp] == 0) {//방문 여부도 체크해야 한다
                        linkedList.offer(temp);
                        visit[temp] = visit[front] + 1;
                    }
                    if (visit[end] > 0)
                        break;
                }
                if (visit[end] > 0)
                    break;
            }
        }

        return (visit[end] == 0) ? "impossible" : String.valueOf(visit[end] - 1);
    }

    private static boolean[] isPrime(int start, int end) {
        boolean[] isPrime = new boolean[end + 1];

        //모두 소수로 셋팅
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        //소수가 아닌 것을 거른다
        for (int i = 2; i <= end; i++) {
            for (int j = 2; i * j <= end; j++) {//특정 수의 배수를 제거한다
                isPrime[i * j] = false;
            }
        }
        return isPrime;
    }

    private static int getNum(StringBuilder sb, int i, int j) {
        StringBuilder newSb = new StringBuilder();
        for (int k = 0; k < 4; k++) {
            if (k == i) {
                newSb.append(j);
            } else {
                newSb.append(sb.charAt(k) - '0');
            }
        }
        return Integer.valueOf(newSb.toString());
    }
}

