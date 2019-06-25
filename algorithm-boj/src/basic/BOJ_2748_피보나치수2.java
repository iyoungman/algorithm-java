package basic;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-05-01.
 */

public class BOJ_2748_피보나치수2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long input = scan.nextInt();
		long first = 0;
		long second = 1;
		long hap = 1;

		for (long i = 2; i <= input; i++) {
			hap = first + second;
			first = second;
			second = hap;
		}
		System.out.println(hap);
	}
}
