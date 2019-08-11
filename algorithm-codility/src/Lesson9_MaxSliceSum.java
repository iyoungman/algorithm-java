/**
 * Created by YoungMan on 2019-08-10.
 */

public class Lesson9_MaxSliceSum {

	public static void main(String[] args) {
		int a[] = {3, 2, -6, 4, 0};

		//결과 출력
		System.out.println(solution2(a));
	}

	private static int solution(int[] a) {
		int max = Integer.MIN_VALUE;
		int psum = 0;

		for (int i = 0; i < a.length; i++) {
			psum = Math.max(psum, 0) + a[i];
			max = Math.max(psum, max);
		}

		return max;
	}

	private static int solution2(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}
