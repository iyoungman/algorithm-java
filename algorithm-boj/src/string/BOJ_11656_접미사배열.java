package basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by YoungMan on 2019-04-18.
 */

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) {

		String input = "baekjoon";

		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			list.add(
					input.substring(i)
			);
		}
		Collections.sort(list);
		System.out.println(list);
	}
}
