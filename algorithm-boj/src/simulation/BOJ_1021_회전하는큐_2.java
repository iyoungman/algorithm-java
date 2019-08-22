package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-22.
 * https://www.acmicpc.net/problem/1021
 * List.remove 도 값을 반환한다
 */

public class BOJ_1021_회전하는큐_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//큐의 크기
        int m = scanner.nextInt();//뽑아내는 수 개수
        List<Integer> nums = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            nums.add(i);
        }

        for (int i = 0; i < m; i++) {
            int extract = scanner.nextInt() - 1;//현재 뽑는 수

            while (true) {
                if (nums.get(0) == extract) {
                    nums.remove(0);
                    break;
                } else {
                    if (nums.indexOf(extract) <= nums.size() / 2) {
                        nums.add(nums.size() - 1, nums.remove(0));//오른쪽으로 이동
                    } else {
                        nums.add(0, nums.remove(nums.size() - 1));//왼쪽으로 이동
                    }
                    count++;
                }
            }
        }

        //결과 출력
        System.out.println(count);
    }

}
