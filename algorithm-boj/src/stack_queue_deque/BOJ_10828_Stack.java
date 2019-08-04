package stack_queue_deque;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YoungMan on 2019-08-04.
 * 단방향, 후입선출
 * peek() 은 삭제 X, 조회 O
 */

public class BOJ_10828_Stack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Stack<Integer> stack = new Stack<Integer>();

		//명령 입력
		for (int i = 0; i < n; i++) {
			String[] lines = scanner.nextLine().split(" ");
			switch (lines[0]) {
				case "push":
					stack.push(Integer.parseInt(lines[1]));
					break;
				case "pop":
					if (stack.empty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.pop());
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					int result = stack.empty() ? 1 : 0;
					System.out.println(result);
					break;
				case "top":
					if (stack.empty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.peek());
					}
					break;
			}
		}

	}
}
