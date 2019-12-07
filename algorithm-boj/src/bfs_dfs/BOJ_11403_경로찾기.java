package bfs_dfs;

import java.util.*;

/**
 * Created by YoungMan on 2019-06-30.
 * https://www.acmicpc.net/problem/11403
 * 이어져있는지만 확인하면 될것 같다
 * 다른 정점과의 연결관계는 BFS 보다 DFS 가 유용
 */

public class BOJ_11403_경로찾기 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static boolean[] visit;
    private static int[][] result;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        visit = new boolean[n];
        result = new int[n][n];

        //정점 만큼 초기화
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scanner.nextInt() == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        //계산
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit, false);
            dfs(i);

            for (int j = 0; j < n; j++) {
                if (visit[j]) {
                    result[i][j] = 1;
                }
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int start) {
        for (int end : graph.get(start)) {
            if (!visit[end]) {//방문하지 않았다면
                visit[end] = true;
                dfs(end);
            }
        }
    }
}
