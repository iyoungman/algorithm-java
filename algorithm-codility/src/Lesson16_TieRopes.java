/**
 * Created by YoungMan on 2019-08-11.
 */

public class Lesson16_TieRopes {

	public static void main(String[] args) {
		int k = 4;
		int[] lopes = {1, 2, 3, 4, 1, 1, 3};

		System.out.println(solution(k, lopes));
	}

	private static int solution(int k, int[] lopes) {
		int count = 0;
		int temp = 0;

		for (int i = 0; i < lopes.length; i++) {
			if(lopes[i] < k) {
				temp = temp + lopes[i];
			}
			if(lopes[i] >= k || temp >= k) {
				count++;
				temp = 0;
			}
		}

		return count;
	}
}
