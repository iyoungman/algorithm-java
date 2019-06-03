package basic;

/**
 * Created by YoungMan on 2019-04-18.
 */

public class BOJ_10799_쇠막대기 {

	public static void main(String[] args) {
		String input = "(((()(()()))(())()))(()())";
		char[] chars = input.toCharArray();
		int sum = 0, count = 0;
		char before = ')';

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				count++;
			} else {
				if (before == '(') {
					count--;
					sum = sum + count;
				} else {
					if (count > 0)
						sum = sum + 1;
					count--;
				}
			}
			before = chars[i];
		}

		System.out.println(sum);
	}
}
