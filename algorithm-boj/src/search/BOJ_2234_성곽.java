//package search;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * Created by YoungMan on 2019-06-11.
// */
//
//public class BOJ_2234_성곽 {
//
//	static Info[][] graph;
//	static boolean[][] visit;
//
//	public static void main(String[] args) {
//
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();//열의 개수
//		int m = scanner.nextInt();//행의 개수
//
//		graph = new Info[m][n];
//		visit = new boolean[m][n];
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				int value = scanner.nextInt();
//				graph[i][j] = new Info(value);
//			}
//		}
//
//
//
//	}
//
//	static void bfs() {
//		Queue<Integer> queue = new LinkedList<Integer>();
//		queue.offer(start);
//		visit[start] = true;
//
//		while (!queue.isEmpty()) {
//			int front = queue.poll();
//			System.out.print(front + " ");
//
//			for (int i = 0; i < graph.get(front).size(); i++) {
//				int end = graph.get(start).get(i);
//				if (!visit[end]) {//방문하지 않았다면
//					visit[end] = true;
//					queue.offer(end);
//				}
//			}
//		}
//
//	}
//}
//
//class Info {
//	int value;
//	boolean 서, 북, 동, 남;//벽이 있으면 true
//
//	public Info(int value) {
//		this.value = value;
//		String valueStr = String.format("%04d",
//				Integer.toBinaryString(value));
//
//		if(valueStr.charAt(0) == 1) {
//			남 = true;
//		}
//		if(valueStr.charAt(1) == 1) {
//			동 = true;
//		}
//		if(valueStr.charAt(2) == 1) {
//			북 = true;
//		}
//		if(valueStr.charAt(3) == 1) {
//			서 = true;
//		}
//	}
//
//
//}
