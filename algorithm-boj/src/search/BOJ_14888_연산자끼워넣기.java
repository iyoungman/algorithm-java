package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-24.
 * https://www.acmicpc.net/problem/14888
 * 순열 문제
 * 중복 순열이지만 {1,1,2..} 와 같이 구성
 */

public class BOJ_14888_연산자끼워넣기 {

    private static int[] nums;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//수의 개수
        nums = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        //숫자 입력
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            int count = scanner.nextInt();
            if (count > 0) {
                for (int k = 0; k < count; k++) {
                    list.add(i);
                }
            }
        }

        int[] operations = toArray(list);
        permutationAll(operations, 0, n - 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static int[] toArray(ArrayList<Integer> intList) {
        int[] result = new int[intList.size()];
        int i = 0;
        for (int index : intList) {
            result[i++] = index;
        }
        return result;
    }

    /**
     * N개의 순열
     */
    private static void permutationAll(int[] operations, int depth, int n) {
        if (depth == n) {
            int temp = getNum(operations);
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(operations, depth, i);
            permutationAll(operations, depth + 1, n);
            swap(operations, depth, i);
        }
    }

    private static void swap(int[] nums, int depth, int i) {
        int temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }

    private static int getNum(int[] operations) {
        int result = nums[0];
        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == 0) {
                result = result + nums[i + 1];
            } else if (operations[i] == 1) {
                result = result - nums[i + 1];
            } else if (operations[i] == 2) {
                result = result * nums[i + 1];
            } else {
                result = result / nums[i + 1];
            }
        }

        return result;
    }
}
