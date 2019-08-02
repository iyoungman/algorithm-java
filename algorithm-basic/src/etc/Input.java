package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by YoungMan on 2019-06-13.
 */

public class Input {

	public static void main(String[] args) throws Exception {

		//Scanner
		Scanner scanner = new Scanner(System.in);

		String str = scanner.next();//공백 단위로 문자열 읽는다
		scanner.nextLine();//next 와 nextLine 같이 사용했을 때 오류해결
		String strLine = scanner.nextLine();//개행 단위로 문자열 읽는다
		System.out.println(str);
		System.out.println(strLine);


		System.out.println("==========================================================================");


		//BuffedReader + StringTokenizer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//테스트 케이스 개수
		StringTokenizer st = new StringTokenizer(br.readLine());//공백을 기준으로 자른다, Split 보다 더 효율적이다
		System.out.println(st.countTokens());
		for (int i = 0; i < st.countTokens(); i++) {
			System.out.println(st.nextToken());//토큰을 출력후 제거
		}
	}
}
