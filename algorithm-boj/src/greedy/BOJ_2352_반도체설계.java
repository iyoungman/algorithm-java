package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-21.
 * https://www.acmicpc.net/problem/2352
 * 최대 증가 부분수열로써 11053번과 유사
 */

public class BOJ_2352_반도체설계 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ports = new int[n + 1];
        int[] d = new int[n + 1];

        //연결 포트 입력
        for (int i = 1; i <= n; i++) {
            ports[i] = scanner.nextInt();
        }

        d[1] = 1;

        //BottomUp
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                d[i] = (ports[i] > ports[j]) ? Math.max(d[i], d[j] + 1) : Math.max(d[i], 1);
            }
        }

        //결과 출력
        Arrays.sort(d);//최대값을 추출하기 위해
        System.out.println(d[n]);
    }
}
