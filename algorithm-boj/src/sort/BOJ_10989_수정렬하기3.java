package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-05-01.
 */

public class BOJ_10989_수정렬하기3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			int input = scan.nextInt();
			list.add(input);
		}

		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}
}
