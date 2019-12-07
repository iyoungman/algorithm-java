package etc;

/**
 * Created by YoungMan on 2019-11-08.
 */

public class PGMS_가장긴팰린드롬 {

	public static void main(String[] args) {
		String s = "caaaaaa";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int result = 0;
		for (int i = s.length(); i > 1; i--) {
			if (i % 2 == 1) {//홀수
				if (isOdd(i, s)) {
					result = i;
					break;
				}
			} else {//짝수
				if (isEven(i, s)) {
					result = i;
					break;
				}
			}
		}

		return result == 0 ? 1 : result;
	}

	private static boolean isOdd(int length, String s) {
		for (int i = 0; i + length <= s.length(); i++) {
			String ss = s.substring(i, i + length);
			char[] charArray = ss.toCharArray();
			boolean check = true;
			for (int kk = 0; kk < (ss.length() - 1) / 2; kk++) {
				if (charArray[kk] != charArray[ss.length() - 1 - kk]) {
					check = false;
					break;
				}
			}

			if (check) return true;
		}
		return false;
	}

	private static boolean isEven(int length, String s) {
		for (int i = 0; i + length <= s.length(); i++) {
			String ss = s.substring(i, i + length);
			char[] charArray = ss.toCharArray();
			boolean check = true;
			for (int kk = 0; kk < (ss.length()) / 2; kk++) {
				if (charArray[kk] != charArray[ss.length() - 1 - kk]) {
					check = false;
					break;
				}
			}

			if (check) return true;
		}
		return false;
	}
}
