package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-28.
 */

public class BOJ_1748_수이어쓰기1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int digit = getDigit(n);
        double result = 0;
        int temp = 9;
        for (int i = 0; i < digit; i++) {
            if (i == digit - 1) {
                int num = getNum(digit, n);
                result = result + (i + 1) * (num);
            } else {
                result = result + (i + 1) * (temp * Math.pow(10, i));
            }
        }

        System.out.println((int) result);
    }

    private static int getDigit(int n) {
        String strN = String.valueOf(n);
        return strN.length();
    }

    private static int getNum(int digit, int n) {
        int start = (int) Math.pow(10, digit - 1);//100
        return n - start + 1;
    }
}
