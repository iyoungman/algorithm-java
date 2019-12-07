package string;

/**
 * Created by YoungMan on 2019-04-17.
 * %04d 의 의미 -> 명령의 시작, 채워질 문자, 총 자리수, 십진정수
 * 주로 int -> string 변환시 0이 없어지는 문제에서 사용(ex : 011을 string 으로 변환하면 11로 됨)
 */

public class StringFormat {

	public static void main(String[] args) {

		int testInt = 11;
		String intResult = String.format("%05d", testInt);
		String testStr = "11";
		String strResult = String.format("%5s", testStr);

		System.out.println(intResult);
		System.out.println(strResult);

	}
}
