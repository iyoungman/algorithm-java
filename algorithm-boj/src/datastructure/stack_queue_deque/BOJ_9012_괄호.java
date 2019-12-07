package datastructure.stack_queue_deque;

import java.util.Stack;

/**
 * Created by YoungMan on 2019-04-18.
 * https://www.acmicpc.net/problem/9012
 */

public class BOJ_9012_괄호 {

	public static void main(String[] args) {

		String input1 = "(())())";
		String input2 = "(()())((()))";

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input2.length(); i++) {
			stack.add(input2.charAt(i));
		}
		int count = 0;
		for (int i = 0; i < input2.length(); i++) {
			boolean check = stack.pop() == '(';
			if (check) {
				count++;
				continue;
			}
			count--;
		}

		if (count == 0)
			System.out.println("YES");
		else
			System.out.println("NO");

	}
}
