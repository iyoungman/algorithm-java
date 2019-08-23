package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-23.
 * https://www.acmicpc.net/problem/9517
 */

public class BOJ_9517_아이러브크로아티아 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();//폭탄을 들고있는 사람
        int n = scanner.nextInt();//질문의 개수
        int end = 210;
        int time = 0;

        for (int i = 0; i < n; i++) {
            time = time + scanner.nextInt();
            if(time > end) {
                break;
            }
            char response = scanner.next().charAt(0);
            if(response == 'T') {
                k = getNext(k);
            }
        }

        //결과 출력
        System.out.println(k);
    }

    private static int getNext(int current) {
        return (current + 1 == 9) ? 1 : current + 1;
    }
}
