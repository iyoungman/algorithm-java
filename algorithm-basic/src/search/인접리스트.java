package search;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-11.
 * 양방향
 */

public class 인접리스트 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int V = scanner.nextInt();//정점
		int E = scanner.nextInt();//간선

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		//정점의 개수만큼 초기화
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		//간선 입력
		for (int i = 0; i < E; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			graph.get(start).add(end);
			graph.get(end).add(start);//양방향이므로
		}

		//인접 리스트 출력 -> 0번째 원소는 비어있다
		System.out.println(graph);

	}


}
