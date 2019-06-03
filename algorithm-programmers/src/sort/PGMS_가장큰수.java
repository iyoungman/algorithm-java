package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YoungMan on 2019-04-28.
 * 문자열 연산이 많으므로 StringBuilder사용
 * Comparator인터페이스를 구현하여 직접 비교 구현
 */

public class PGMS_가장큰수 {

	public static void main(String[] args) {

		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {0,0,0,0};

		System.out.println(solution(numbers));
	}

	static String solution(int[] numbers) {
		String answer = "";
		String[] numbersStr = new String[numbers.length];
		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < numbers.length; i++) {
			numbersStr[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(numbersStr, new Compare());

		for(String s : numbersStr)
			stringBuilder.append(s);

		answer = numbersStr[0].equals("0") ? "0" : stringBuilder.toString();
		return answer;
	}
}

class Compare implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return (o2 + o1).compareTo(o1 + o2);
	}
}
