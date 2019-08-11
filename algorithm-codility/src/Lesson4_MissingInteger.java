import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-10.
 */

public class Lesson4_MissingInteger {

	public static void main(String[] args) {
		int[] a = {1, 3, 6, 4, 1, 2};

		//결과 출력
		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		Arrays.sort(a);

		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			if ((i != 0 && a[i] == a[i - 1]) || a[i] <= 0) {
				continue;
			}
			if (a[i] != ++temp) {
				return temp;
			}
		}

		return temp + 1;
	}
}
