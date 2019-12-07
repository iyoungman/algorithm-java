package union_find;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-13.
 * https://www.acmicpc.net/problem/2606
 */

public class BOJ_2606_바이러스 {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//컴퓨터 수
        int m = scanner.nextInt();//연결 수
        parent = new int[n + 1];
        setting();

        for (int i = 0; i < m; i++) {
            int one = scanner.nextInt();
            int two = scanner.nextInt();
            union(one, two);
        }

        int result = 0;
        for (int i = 2; i < parent.length; i++) {
            if (find(i) == 1) {//왜 parent[i] == 1 주의
                result++;
            }
        }

        System.out.println(result);
    }

    private static void setting() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * x의 부모를 찾는 함수
     */
    private static int find(int x) {
        if (x == parent[x])
            return x;
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    private static void union(int x, int y) {
        x = find(x);//부모
        y = find(y);//부모

        if (x != y) {// 같은 부모를 가지고 있지 않을 때
            if (x < y)
                parent[y] = x;//y의 부모는 x
            else
                parent[x] = y;//x의 부모는 y
        }
    }

}
