import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-04-17.
 */

public class Kakao1_2 {

	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) {

		String input = "1D2S3T*";
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < input.length(); i++) {
			if (isNumber(input.substring(i, i + 1))) {
				list.add(i);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			String str = "";
			if (i != list.size() - 1) {
				str = input.substring(list.get(i), list.get(i + 1));
				result.add(getScore(str, i));
				continue;
			}
			str = input.substring(list.get(i));
			result.add(getScore(str, i));
		}
		System.out.println("합계는 " + result.stream().mapToInt(i -> i).sum());
	}


	static boolean isNumber(String s) {
		return s.matches("-?\\d+(\\.\\d+)?");
	}


	static int getScore(String s, int currentIndex) {

		double score = 0;
		if(s.charAt(1) == 'S') {
			score = Math.pow((double)(s.charAt(0) - '0'), 1);
		} else if(s.charAt(1) == 'D') {
			score = Math.pow((double)(s.charAt(0) - '0'), 2);
		} else {
			score = Math.pow((double)(s.charAt(0) - '0'), 3);
		}

		if(s.length() == 3) {
			score = s.charAt(2) == '*' ? score * 2 : score * -1;
			if(currentIndex != 0) {
				result.set(currentIndex - 1, result.get(currentIndex - 1) * 2);
			}
		}
		return (int)score;
	}


}
