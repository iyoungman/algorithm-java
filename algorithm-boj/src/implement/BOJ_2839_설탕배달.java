package implement;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-30.
 * https://www.acmicpc.net/problem/2839
 * 5만 나누기 -> 5로 나누고 나머지 3으로 나누기 -> 3만 나누기
 */

public class BOJ_2839_설탕배달 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//설탕

        int fiveCount = 0;
        int temp = 0;
        int threeCount = 0;
        while (true) {
            fiveCount = n / 5;
            int remain = n - (5 * (fiveCount - temp));
            if (remain % 3 == 0) {
                threeCount = remain / 3;
                break;
            } else {
                if (fiveCount - temp == 0) {
                    System.out.println(-1);
                    return;
                }
                temp++;
            }
        }

        //결과 출력
        System.out.println(fiveCount - temp + threeCount);
    }
}
