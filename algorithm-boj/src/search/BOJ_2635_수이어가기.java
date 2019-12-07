package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-12.
 * https://www.acmicpc.net/problem/2635
 */

public class BOJ_2635_수이어가기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;

        int second = 0;
        for (int i = n; i > 0; i--) {
            int tempCount = getCount(n, i);
            if (tempCount > max) {
                max = tempCount;
                second = i;
            }
        }

        ArrayList<Integer> resultList = getNums(n, second);
        System.out.println(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i) + " ");
        }
    }

    private static int getCount(int n, int second) {
        int count = 0;

        int temp = 0;
        while (temp >= 0) {
            temp = n - second;
            count++;

            n = second;
            second = temp;
        }

        return count;
    }

    private static ArrayList<Integer> getNums(int n, int second) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(n);
        nums.add(second);

        int temp = 0;
        while (temp >= 0) {
            temp = n - second;
            if (temp >= 0) {
                nums.add(temp);
            }

            n = second;
            second = temp;
        }

        return nums;
    }
}
