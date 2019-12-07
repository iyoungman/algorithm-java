package bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-10-09.
 */

public class BOJ_2644_촌수계산 {

    private static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//전체 사람수
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int m = scanner.nextInt();//간계의 수

        ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int one = scanner.nextInt();
            int two = scanner.nextInt();
            relations.get(one).add(two);
            relations.get(two).add(one);
        }

        bfs(start, end, relations);
        System.out.println(result);
    }

    private static void bfs(int start, int end, ArrayList<ArrayList<Integer>> relations) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (relations.get(start).size() == 0 || relations.get(end).size() == 0) {
            result = -1;
            return;
        }
        int[] visit = new int[relations.size()];
        visit[start] = 0;
        linkedList.offer(start);

        while (linkedList.size() != 0) {
            int front = linkedList.poll();

            for (int i = 0; i < relations.get(front).size(); i++) {
                int next = relations.get(front).get(i);
                if (visit[next] == 0) {//방문하지 않았다면
                    visit[next] = visit[front] + 1;
                    linkedList.offer(next);
                }
            }
        }

        result = (visit[end] == 0) ? -1 : visit[end];
    }
}
