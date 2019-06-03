package basic;

/**
 * Created by YoungMan on 2019-04-18.
 * https://www.acmicpc.net/problem/10824
 */

public class BOJ_10824_네수 {

	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40;

		int hap = Integer.parseInt(String.valueOf(a).concat(String.valueOf(b)))
				+ Integer.parseInt(String.valueOf(c).concat(String.valueOf(d)));

		System.out.println(hap);
	}
}
