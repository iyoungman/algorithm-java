package sort;

import java.util.*;

/**
 * Created by YoungMan on 2019-05-01.
 */

public class BOJ_2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < num; i++) {
			int input = scan.nextInt();
			set.add(input);
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		for (int i : list) {
			System.out.println(i);
		}
	}
}
