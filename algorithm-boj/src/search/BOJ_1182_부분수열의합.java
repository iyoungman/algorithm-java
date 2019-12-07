package search;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-04.
 * https://www.acmicpc.net/problem/1182
 * 무언가 차례대로 출력하는게 아니라 값만 구하면 된다
 */

public class BOJ_1182_부분수열의합 {

    private static int count;
    private static int n;
    private static int s;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//개수
        s = scanner.nextInt();//정수
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        dfs(0, 0);

        System.out.println(count);
    }

    private static void dfs(int sum, int index) {
        if (index == nums.length) {
            return;
        }
        if (sum + nums[index] == s) {
            count++;
        }
        dfs(sum, index + 1);//현 인덱스의 값 더하지 않았을 때
        dfs(sum + nums[index], index + 1);//더했을 때
    }
}
