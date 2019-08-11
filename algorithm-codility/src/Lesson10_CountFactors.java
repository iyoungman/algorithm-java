/**
 * Created by YoungMan on 2019-08-10.
 */

public class Lesson10_CountFactors {

	public static void main(String[] args) {
		int a = 9;
		System.out.println(solution(a));
	}

	private static int solution(int n) {
		int count = 0;
		int i;

		for (i = 1; i * i < n; i++) {
			if (n % i == 0) {
				count = count + 2;
			}
		}
		if (i * i == n) {
			count = count + 1;
		}

		return count;
	}
}
