package search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by YoungMan on 2019-11-05.
 * https://www.acmicpc.net/problem/1339
 * 알파벳을 숫자로 나오는 과정에서 답은 나오지만 시간초과가 난다
 * 풀이 1. 백트래킹보다는 모든 경우를 다 해봤다
 * 풀이 2. 각 알파벳에 가중치를 구해 9~0으로 할당하는 방법도 있다
 */

public class BOJ_1339_단어수학 {

    private static String[] words;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        words = new String[n];
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            words[i] = s;
            for (int k = 0; k < s.length(); k++) {
                characterSet.add(s.charAt(k));
            }
        }

        permutationAll(toArray(characterSet), 0, characterSet.size());

        System.out.println(max);
    }

    private static char[] toArray(Set<Character> intSet) {
        char[] result = new char[intSet.size()];
        int i = 0;
        for (char index : intSet) {
            result[i++] = index;
        }
        return result;
    }

    /**
     * N개의 순열
     */
    private static void permutationAll(char[] nums, int depth, int n) {
        if (depth == n) {
            //할일
            max = Math.max(max, getSum(nums));
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(nums, depth, i);
            permutationAll(nums, depth + 1, n);
            swap(nums, depth, i);
        }
    }

    private static void swap(char[] nums, int depth, int i) {
        char temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }

    private static int getSum(char[] nums) {
        int[] alphabet = new int[26];//매번 변경해주는 것보다 배열에 알파벳에 따른 숫자를 저장
        for (int i = 0; i < nums.length; i++) {
            alphabet[nums[i] - 65] = 9 - i;
        }

        int result = 0;
        for (String word : words) {
            char[] array = word.toCharArray();
            int[] temp = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                temp[i] = alphabet[array[i] - 65];
            }
            result = result + getNum(temp);
        }

        return result;
    }

    private static int getNum(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }
        return Integer.valueOf(sb.toString());
    }
}
