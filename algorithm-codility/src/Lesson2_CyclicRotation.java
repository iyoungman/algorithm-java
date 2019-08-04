import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-04.
 */

public class Lesson2_CyclicRotation {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		int[] B = new int[A.length];
		int K = 3;

		for (int i = 0; i < A.length; i++) {
			if (i + K <= A.length - 1) {
				B[i + K] = A[i];
			} else {//넘으면
				int index = (i + K) - (A.length);
				B[index] = A[i];
			}
		}

		//결과 출력
		Arrays.stream(B)
				.forEach(i -> System.out.println(i));
	}
}
