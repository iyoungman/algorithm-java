package findrule;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-05-01.
 */

public class BOJ_1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int[] result = new int[input];

		for (int j = 0; j < input; j++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int count = 3;

			int temp = 1;
			int plus = 2;
			int num = 0;

			for(int i = 1; i<= end - start - 2; i++) {
				if(i == temp + plus) {
					count = count + 1;
					temp = temp + plus;
					num++;
					if(num == 2) {
						num = 0;
						plus++;
					}
				}
			}
			result[j] = count;
		}

		for(int res : result) {
			System.out.println(res);
		}
		scanner.close();
	}
}
