package greedy;

/**
 * Created by YoungMan on 2019-08-12.
 */

public class PGMS_조이스틱 {

	public static void main(String[] args) {
		String name = "JAZ";

		//결과 출력
		System.out.println(solution(name));
	}


	private static int solution(String name) {
		int[] count = new int[name.length()];
		for (int i = 0; i < name.length(); i++) {
			char alphabet = name.charAt(i);
			count[i] = getCount(alphabet);
		}

		int temp = count[0];
		boolean start = false;
		for (int i = 1; i < count.length; i++) {
			if (count[i] != 0 && !start) {
				start = true;
			}
			if (start) {
				temp = temp + count[i];
				temp++;
			}
		}

		int temp2 = count[0];
		for (int i = count.length - 1; i > 0; i--) {
			if (count[i] != 0 && !start) {
				start = true;
			}
			if (start) {
				temp2 = temp2 + count[i];
				temp2++;
			}
		}

		return Math.min(temp, temp2);
	}

	private static int getCount(char alphabet) {
		int count = alphabet - 'A';
		return (count > 13) ? 26 - count : count;
	}
}
