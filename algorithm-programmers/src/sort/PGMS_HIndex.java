package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YoungMan on 2019-11-08.
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 * https://dasomitlog.com/36
 */

public class PGMS_HIndex {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

	private static int solution(int[] citations) {
		Integer[] reverse = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(reverse, Comparator.reverseOrder());

		int result = 0;
		for (int i = 0; i < reverse.length; i++) {
			if(reverse[i] >= i + 1) {
				result++;
			} else {
				break;
			}
		}

		return result;
	}
}
