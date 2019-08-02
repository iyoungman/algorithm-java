package etc;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-13.
 * 윤년 : 2월 29일, 4년에 1번
 * 평년 : 1년이 365일인 보통의 해
 */

public class 윤년_평년_구하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "년은 윤년");
		} else {
			System.out.println(year + "년은 평년");
		}
	}
}
