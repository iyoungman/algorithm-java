/**
 * Created by YoungMan on 2019-08-10.
 */

public class Lesson5_PassingCars {

	public static void main(String[] args) {
		int[] a = {0, 1, 0, 1, 1};

		//결과 출력
		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		int result = 0;
		int mul = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				mul++;
			} else {
				result = result + mul;
			}
		}

		return (result > 1000000000) ? -1 : result;
	}

}
