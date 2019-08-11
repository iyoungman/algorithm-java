import java.util.Stack;

/**
 * Created by YoungMan on 2019-08-09.
 * 0은 왼쪽, 1은 오른쪽
 */

public class Lesson7_Fish {

	public static void main(String[] args) {
		int[] a = {4, 3, 2, 1, 5};//물고기의 힘
		int[] b = {0, 1, 1, 0, 1};//방향

		//결과 출력
		System.out.println(solution(a, b));
	}

	private static int solution(int[] a, int[] b) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] == 1) {
				stack.push(i);
			} else {//0일때
				if (stack.isEmpty()) {
					result++;
				} else {
					while (stack.size() > 0) {
						int index = stack.peek();//1인 물고기
						if (a[index] < a[i]) {
							stack.pop();
						} else {
							break;
						}
					}
					if (stack.size() == 0) {
						result++;
					}
				}
			}
		}

		return result + stack.size();
	}
}
