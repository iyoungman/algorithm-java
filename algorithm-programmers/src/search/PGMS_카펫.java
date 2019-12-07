package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by YoungMan on 2019-09-19.
 */

public class PGMS_카펫 {

	public static void main(String[] args) {
		int brown = 10;
		int red = 2;

		System.out.println(Arrays.toString(solution(brown, red)));
	}

	private static int[] solution(int brown, int red) {
		//약수로 분해
		int[] result = new int[2];
		ArrayList<int[]> nums = getNums(red);

		for (int[] index : nums) {
			int horizontal = Math.max(index[1], index[0]);
			int vertical = Math.min(index[1], index[0]);

			if (horizontal * 2 + vertical * 2 + 4 == brown) {
				result[0] = horizontal + 2;
				result[1] = vertical + 2;
				break;
			}
		}

		return result;
	}

	//약수 리스트
	private static ArrayList<int[]> getNums(int n) {
		ArrayList<int[]> nums = new ArrayList<>();

		for (int i = 1; i * i <= n; i++) {
			if (i * i == n) {
				nums.add(new int[]{i, i});
				break;
			}
			if (n % i == 0) {
				nums.add(new int[]{i, n / i});
			}
		}

		return nums;
	}

}
