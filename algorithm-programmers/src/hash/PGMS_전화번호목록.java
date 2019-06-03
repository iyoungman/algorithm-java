package hash;

/**
 * Created by YoungMan on 2019-04-23.
 * 접두어 포함 여부를 확인
 * Contains 는 해당 없다
 * 난 substring 과 length 를 이용했는데 startsWith
 * startsWith 이용하면 길이 고려할 필요 없다
 */

public class PGMS_전화번호목록 {

	public static void main(String[] args) {

		String[] phoneBook = {"119", "97674223", "1195524421"};
		System.out.println(solution(phoneBook));
	}

	static boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (i == j)
					continue;
				if(phone_book[i].startsWith(phone_book[j]))
					return false;
			}
		}
		return answer;
	}

}
