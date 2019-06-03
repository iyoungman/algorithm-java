package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by YoungMan on 2019-04-18.
 * push pop size empty top
 */

public class BOJ_10828_Stack {

	public static void main(String[] args) {

		int input = 14;
		List<String> inputStr = Arrays.asList("push 1", "push 2", "top", "size", "empty", "pop", "pop", "pop", "size", "empty", "pop", "push 3", "empty", "top");

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < input; i++) {
			if (inputStr.get(i).contains("push")) {
				stack.push(Integer.parseInt(
						inputStr.get(i).replace("push ", "")
						)
				);
				continue;
			}
			if (inputStr.get(i).contains("pop")) {
				if (stack.empty()) {
					System.out.println("pop " + -1);
				} else {
					System.out.println("pop " + stack.pop());
				}
				continue;
			}
			if (inputStr.get(i).contains("size")) {
				System.out.println("size " + stack.size());
				continue;
			}
			if (inputStr.get(i).contains("empty")) {
				int a = stack.empty() ? 1 : 0;
				System.out.println("empty " + a);
				continue;
			}
			if(stack.empty()) {
				System.out.println("top " + -1);
			} else {
				System.out.println("top " + stack.peek());
			}
		}

	}
}