package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-05.
 * https://www.acmicpc.net/problem/10610
 * 최소 0이 한개 있어야하며 각 자리수의 합이 3의 배수
 */

public class BOJ_10610_30 {

	static int total = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//조건에 따라 String 으로 입력받는다. int 나 long 의 범위에 벗어나기 때문이다.
		String n = scanner.nextLine();

		if (n.contains("0")) {
			Integer[] digitsNumber = getSumOfDigitsNumber(n);
			if(total % 3 != 0) {
				System.out.println(-1);
				return;
			}
			System.out.println(getMaxNumber(digitsNumber));
		} else {
			System.out.println(-1);
		}
	}

	//int 의 각 자리 숫자합을 구하는 함수
	private static Integer[] getSumOfDigitsNumber(String num) {
		Integer[] digitsNumber = new Integer[num.length()];
		for(int i =0; i<num.length(); i++) {
			int n = Integer.parseInt(num.substring(i, i+1));
			total = total + n;
			digitsNumber[i] = n;
		}

		return digitsNumber;
	}

	//30의 배수중 최대값
	private static String getMaxNumber(Integer[] digitsNumber) {
		Arrays.sort(digitsNumber, Collections.reverseOrder());

		//String 으로 처리할시 String 은 불변 객체이기 때문에 오륙가 난다
		StringBuilder max = new StringBuilder();
		for (Integer integer : digitsNumber) {
			max.append(integer);
		}
		return max.toString();
	}
}
