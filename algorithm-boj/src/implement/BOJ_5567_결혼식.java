package implement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-24.
 * https://www.acmicpc.net/problem/5567
 */

public class BOJ_5567_결혼식 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//동기의 수
        int m = scanner.nextInt();//관계도의 수
        int[][] input = new int[m][2];//입력

        for (int i = 0; i < m; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] relations = checkRelations(n, input);

        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (relations[i] == 1 || relations[i] == 2) {
                result++;
            }
        }

        //결과 출력
        System.out.println(result);
    }

    private static int[] checkRelations(int n, int[][] input) {
        int[] relations = new int[n + 1];//0, 1, 2

        for (int i = 0; i < input.length; i++) {
            int me = input[i][0];
            int you = input[i][1];

            if (me == 1) {
                relations[you] = 1;
                continue;
            }

            if (relations[me] == 1 && relations[you] == 1) {
                continue;
            } else if (relations[me] == 1) {
                relations[you] = 2;
            } else if (relations[you] == 1) {
                relations[me] = 2;
            }
        }

        return relations;
    }
}
