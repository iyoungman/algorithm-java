package datastructure.tree;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-31.
 * https://www.acmicpc.net/problem/1991
 * 이진 트리
 */

public class BOJ_1991_트리순회 {

    private static int[][] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//이진 트리 노드 개수
        scanner.nextLine();
        nodes = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int me = line[0].charAt(0);
            nodes[me - 65][0] = line[1].charAt(0) - 65;
            nodes[me - 65][1] = line[2].charAt(0) - 65;
        }

        preOrder(0);//전위 순회
        System.out.println();

        inOrder(0);//중위 순회
        System.out.println();

        postOrder(0);//후위 순회
    }

    private static void preOrder(int node) {
        if (node < 0) {
            return;
        }
        char c = (char) (node + 65);
        System.out.print(c);

        preOrder(nodes[node][0]);
        preOrder(nodes[node][1]);
    }

    private static void inOrder(int node) {
        if (node < 0) {
            return;
        }
        char c = (char) (node + 65);

        inOrder(nodes[node][0]);
        System.out.print(c);
        inOrder(nodes[node][1]);
    }

    private static void postOrder(int node) {
        if (node < 0) {
            return;
        }

        char c = (char) (node + 65);

        postOrder(nodes[node][0]);
        postOrder(nodes[node][1]);
        System.out.print(c);
    }
}
