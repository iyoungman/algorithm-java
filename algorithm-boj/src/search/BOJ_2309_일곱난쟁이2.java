package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-10.
 * https://www.acmicpc.net/problem/2309
 * for 문을 사용하는 것보다 조합을 사용하면 편하다
 * 백트래킹으로 한다면 전체적인 구조는 비슷 + sum > 100 이면 return 해주는 방식
 */

public class BOJ_2309_일곱난쟁이2 {

    private static int[] result = new int[7];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[9];
        int[] combNums = new int[7];

        for (int i = 0; i < 9; i++) {
            nums[i] = scanner.nextInt();
        }

        combination(combNums, 9, 7, 0, 0, nums);
        Arrays.sort(result);
        for (int i = 0; i < 7; i++) {
            System.out.println(result[i]);
        }
    }

    private static void combination(int[] combNums, int n, int r, int index, int target, int[] nums) {
        if (r == 0) {//뽑을 것 뽑았으면
            check(combNums, nums);
            return;
        }
        if (target == n)//검사가 끝난 경우
            return;

        combNums[index] = target;
        combination(combNums, n, r - 1, index + 1, target + 1, nums);//뽑는경우
        combination(combNums, n, r, index, target + 1, nums);//안뽑는경우
    }

    private static void check(int[] combNums, int[] nums) {
        int sum = 0;
        for (int index : combNums) {
            sum += nums[index];
        }

        //100이 아니면 리턴
        if (sum != 100) return;

        int i = 0;
        for (int index : combNums) {
            result[i++] = nums[index];
        }
    }
}
