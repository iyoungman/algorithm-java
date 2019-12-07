package union_find;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-13.
 * https://www.acmicpc.net/problem/1717
 */

public class BOJ_1717_집합의연산 {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        parent = new int[n + 1];
        setting();

        for (int i = 0; i < m; i++) {
            int operation = scanner.nextInt();
            int one = scanner.nextInt();
            int two = scanner.nextInt();

            if (operation == 0) {
                union(one, two);
            } else {
                if (isSameParent(one, two)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
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

    /**
     * 같은 부모 노드를 가지는지 확인
     * 연결되어 있는지 확인
     */
    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}
