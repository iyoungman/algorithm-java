package datastructure.tree;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-30.
 * https://www.acmicpc.net/problem/1068
 * 부모의 정보만으로 풀었다
 * 루트가 리프노드가 될 수 있다는 것도 고려해야한다..
 */

public class BOJ_1068_트리 {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = scanner.nextInt();
        }
        int erase = scanner.nextInt();//지울 노드
        if (parents[erase] == -1) {//루트 노드를 지울 때
            System.out.println(0);
            return;
        }

        removeNode(erase);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -10) {//지워진것
                continue;
            }
            boolean isParent = false;
            for (int j = 0; j < n; j++) {
                if (parents[j] == i) {//부모이면 리프노드가 될 수 없다
                    isParent = true;
                    break;
                }
            }
            count = isParent ? count : count + 1;
        }

        //결과 출력
        System.out.println(count);
    }

    private static void removeNode(int eraseNode) {
        parents[eraseNode] = -10;//부모정보 제거

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == eraseNode) {
                removeNode(i);
            }
        }
    }

}
