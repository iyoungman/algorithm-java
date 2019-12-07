package greedy;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_구명보트 {

	public static void main(String[] args) {

	}

	private static int solution(int[] people, int limit) {
		Arrays.sort(people);

		int result = 0;
		int last = people.length;
		for (int i = 0; i < last; i++) {
			int maxLimit = limit - people[i];
			for (int j = last - 1; j > i; j--) {
				if (people[j] > maxLimit) {
					last--;
					result++;
				} else {
					last = j;
					break;
				}
			}
			result++;
			if (i + 1 == last) break;
		}

		return result;
	}
}
