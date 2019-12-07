package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-24.
 * https://www.acmicpc.net/problem/2252
 * 위상정렬
 * 제시한 조건만 맞으면 된다
 * 입력이 4 2, 3 1 이면 4뒤에 2, 3뒤에 1만 오면 된다
 * 즉, 답이 4 2 3 1, 3 4 1 2 둘다 맞다
 */

public class BOJ_2252_줄세우기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//학생 번호
        int m = scanner.nextInt();//비교 횟수

        int[] cntOfLink = new int[n + 1]; // 간선의 수에 대한 배열

        // 가중치가 없는 그래프(인접 리스트 이용)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 단방향 연결 설정
        for (int i = 0; i < m; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.get(v1).add(v2);
            cntOfLink[v2]++; // 후행 정점에 대한 간선의 수 증가
        }

        // 위상 정렬 (A B: A가 B앞에 선다. A가 선행)
        topologicalSort(graph, cntOfLink, n, m);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink, int n, int m) {
        Queue<Integer> queue = new LinkedList();

        // 초기: 선행 정점을 가지지 않는 정점을 큐에 삽입
        for (int i = 1; i < n + 1; i++) {
            if (cntOfLink[i] == 0) { // 해당 정점의 간선의 수가 0이면
                queue.add(i);
            }
        }

        // 정점의 수 만큼 반복
        for (int i = 0; i < n; i++) {
            int v = queue.remove(); // 1. 큐에서 정점 추출
            System.out.print(v + " "); // 정점 출력

            // 2. 해당 정점과 연결된 모든 정점에 대해
            for (int nextV : graph.get(v)) {
                cntOfLink[nextV]--; // 2-1. 간선의 수 감소

                // 2-2. 선행 정점이 이미 출력되어 더이상 선행을 갖지 않게되면
                if (cntOfLink[nextV] == 0) { // 해당 정점의 간선의 수가 0이면
                    queue.add(nextV);
                }
            }
        }
    }

}
