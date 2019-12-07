package greedy;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_큰수만들기 {

	public static void main(String[] args) {

	}

	private static String solution(String number, int k) {
		int[] numberInt = getInt(number);
		StringBuilder stringBuilder = new StringBuilder();
		int length = number.length() - k;

		int start = 0;
		while (length > 0) {
			int max = 0;
			for (int i = start; i <= number.length() - length; i++) {
				if (numberInt[i] > max) {
					max = numberInt[i];
					start = i + 1;
				}
			}

			stringBuilder.append(max);
			length--;
		}

		return stringBuilder.toString();
	}

	private static int[] getInt(String number) {
		int[] result = new int[number.length()];

		for (int i = 0; i < number.length(); i++) {
			result[i] = number.charAt(i) - '0';
		}

		return result;
	}
}
