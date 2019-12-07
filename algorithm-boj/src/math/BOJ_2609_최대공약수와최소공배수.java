package math;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-08.
 * https://www.acmicpc.net/problem/2609
 * GCD(최대공약수), LCM(최소공배수)
 * 최대공약수는 유클리드 호제법을 이용하면 빠르다
 * 최소공배수 = A * B / 최대공약수
 */

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOne = scanner.nextInt();
		int numTwo = scanner.nextInt();

		//결과 출력
		int numGCD = getGCD(numOne, numTwo);
		int numLCM = getLCM(numOne, numTwo, numGCD);
		System.out.println(numGCD);
		System.out.println(numLCM);
	}

	private static int getGCD(int numOne, int numTwo) {
		int min = Math.min(numOne, numTwo);
		min = min / 2;

		for (int i = min; i >= 1; i--) {
			if (numOne % i == 0 && numTwo % i == 0) {
				return i;
			}
		}
		return 1;
	}

	private static int getLCM(int numOne, int numTwo, int numGCM) {
		return numOne * numTwo / numGCM;
	}
}
