package datastructure.stack_queue_deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-04.
 * https://www.acmicpc.net/problem/10845
 * 단방향, 선입선출
 * poll() 삭제 O, peek() 삭제X
 * LinkedList 의 경우  back 을 쉽게 조회할 수 있다
 */

public class BOJ_10845_큐 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Queue<Integer> queue = new LinkedList<>();
		int last = 0;

		//명령 입력
		for (int i = 0; i < n; i++) {
			String[] lines = scanner.nextLine().split(" ");
			switch (lines[0]) {
				case "push":
					last = Integer.parseInt(lines[1]);
					queue.offer(last);
					break;
				case "pop":
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.poll());
					}
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					int result = queue.isEmpty() ? 1 : 0;
					System.out.println(result);
					break;
				case "front":
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.peek());
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(last);
					}
					break;
			}
		}
	}
}
