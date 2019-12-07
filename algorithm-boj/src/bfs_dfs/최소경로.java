package bfs_dfs;

import java.util.LinkedList;

/**
 * Created by YoungMan on 2019-09-19.
 */

public class 최소경로 {

    public static void main(String[] args) {
        int n = 5;
        int k = 17;

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        LinkedList<Integer> linkedList = new LinkedList();
        int[] visit = new int[1000001];
        linkedList.offer(n);
        visit[n] = 0;
        int result = 0;

        while (linkedList.size() != 0) {
            int front = linkedList.poll();
            if (front == k) {
                result = visit[front];
                break;
            }

            if (front + 1 <= 1000000 && visit[front + 1] == 0) {
                linkedList.offer(front + 1);
                visit[front + 1] = visit[front] + 1;
            }
            if (visit[front - 1] == 0) {
                linkedList.offer(front - 1);
                visit[front - 1] = visit[front] + 1;
            }
            if (front * 2 <= 1000000 && visit[front * 2] == 0) {
                linkedList.offer(front * 2);
                visit[front * 2] = visit[front] + 1;
            }
        }

        return result;
    }

}
