package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-18.
 * https://www.acmicpc.net/problem/12813
 */

public class BOJ_12813_이진수연산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int aa = Integer.parseInt(a, 2);
        int bb = Integer.parseInt(b, 2);

        String and = toBinary(aa & bb);
        String or = toBinary(aa | bb);
        String nor = toBinary(aa ^ bb);
        String notA = toBinary(~aa);
        String notB = toBinary(~bb);
//        int notA = ~aa;
//        int notB = ~bb;

        System.out.println(and);
        System.out.println(or);
        System.out.println(nor);
        System.out.println(notA);
        System.out.println(notB);
    }

    private static String toBinary(int num) {
        return String.format("%010d", Integer.parseInt(Integer.toBinaryString(num)));
    }
}
