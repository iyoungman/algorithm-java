package search;

import java.util.ArrayList;

/**
 * Created by YoungMan on 2019-08-14.
 */

public class PGMS_모의고사 {

	public static void main(String[] args) {

	}

	private static int[] solution(int[] answers) {
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;

		for (int i = 0; i < answers.length; i++) {
			int an = answers[i];
			if (an == one[i % one.length]) {
				oneCount++;
			}
			if (an == two[i % two.length]) {
				twoCount++;
			}
			if (an == three[i % three.length]) {
				threeCount++;
			}
		}

		int max = Math.max(oneCount, Math.max(threeCount, twoCount));
		ArrayList<Integer> array = new ArrayList<>();
		if(oneCount == max) {
			array.add(1);
		}
		if(twoCount == max) {
			array.add(2);
		}
		if(threeCount == max) {
			array.add(3);
		}

		int[] result = new int[array.size()];
		int i = 0;
		for(int index : array) {
			result[i++] = index;
		}

		return result;
	}
}
