package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-11.
 */

public class 인접행렬 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();//정점
		int E = scanner.nextInt();//간선

		int[][] graph = new int[V][V];//정점개수 * 정점개수

		//간선 입력
		for (int i = 0; i < E; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			graph[start - 1][end - 1] = 1;
			graph[end - 1][start - 1] = 1;
		}

		//인접 행렬 출력
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
