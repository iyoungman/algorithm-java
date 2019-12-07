package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-04.
 * https://www.acmicpc.net/problem/1759
 * 방법. 조합 후 조건 체크
 */

public class BOJ_1759_암호만들기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int C = scanner.nextInt();
        char[] nums = new char[C];
        int[] combNums = new int[L];

        for (int i = 0; i < C; i++) {
            nums[i] = scanner.next().charAt(0);
        }

        Arrays.sort(nums);
        combination(combNums, C, L, 0, 0, nums);
    }

    /**
     * n개중 r개 조합
     */
    private static void combination(int[] combNums, int n, int r, int index, int target, char[] nums) {
        if (r == 0) {//뽑을 것 뽑았으면
            if (!check(combNums, nums)) {
                return;
            }
            print(combNums, nums);
            return;
        }
        if (target == n)//검사가 끝난 경우
            return;

        combNums[index] = target;
        combination(combNums, n, r - 1, index + 1, target + 1, nums);//뽑는경우
        combination(combNums, n, r, index, target + 1, nums);//안뽑는경우
    }

    private static boolean check(int[] combNums, char[] nums) {
        int consonant = 2;
        int vowel = 1;

        for (int index : combNums) {
            char i = nums[index];
            if (i == 'a' || i == 'e' || i == 'o' || i == 'u' || i == 'i') {
                vowel--;
            } else {
                consonant--;
            }
        }

        return consonant <= 0 && vowel <= 0;
    }

    /**
     * combNums 는 인덱스 조합이다
     */
    private static void print(int[] combNums, char[] nums) {
        for (int index : combNums) {
            System.out.print(nums[index]);
        }
        System.out.println();
    }
}
