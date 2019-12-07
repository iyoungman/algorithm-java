package simulation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-27.
 * https://www.acmicpc.net/problem/16936
 */

public class BOJ_16936_나3곱2 {

    private static ArrayList<Long> nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        nums = new ArrayList<>();
        ArrayList<Long> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextLong());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            long num = contains(nums.get(i));
            result.add(nums.get(i));
            while (true) {
                if (num == -1) {
                    count = 0;
                    result = new ArrayList<>();
                    break;
                } else {
                    result.add(num);
                    count++;
                    num = contains(num);
                    if (count == n - 1) {
                        for (long index : result) {
                            System.out.print(index + " ");
                        }
                        return;
                    }
                }
            }
        }

    }

    private static long contains(long num) {
        if (nums.contains(num * 2)) {
            return num * 2;
        }
        if (nums.contains(num / 3)) {
            return num / 3;
        }
        return -1;
    }

}
