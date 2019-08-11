import java.util.Stack;

/**
 * Created by YoungMan on 2019-08-09.
 */

public class Lesson7_Brackets {

	public static void main(String[] args) {
		String good = "{[()()]}";
		String bad = "([)()]";

		System.out.println(solution(good));
	}

	private static int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char index = s.charAt(i);
			if (index == '[' || index == '{' || index == '(') {
				stack.push(index);
			}

			if(index == ']' || index == '}' || index == ')') {
				if(stack.size() == 0) {
					return 0;
				}
				char pop = stack.pop();
				switch (index) {
					case ')' :
						if(pop != '('){
							return 0;
						}
						break;
					case '}' :
						if(pop != '{'){
							return 0;
						}
						break;
					case ']' :
						if(pop != '['){
							return 0;
						}
						break;
				}
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
