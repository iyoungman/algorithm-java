package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-05-01.
 */

public class BOJ_2747_피보나치수 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int first = 0;
		int second = 1;
		int hap = 1;

		for (int i = 2; i <= input; i++) {
			hap = first + second;
			first = second;
			second = hap;
		}
		System.out.println(hap);
	}
}
