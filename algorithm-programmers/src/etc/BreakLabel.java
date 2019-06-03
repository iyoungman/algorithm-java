package etc;

/**
 * Created by YoungMan on 2019-04-28.
 * 중첩 루프일때 break는 가장 가까운 루프 탈출
 * 중첩 루프를 한꺼번에 탈출하기 위해 label을 사용
 */

public class BreakLabel {

	public static void main(String[] args) {

		Break_Label:
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j<5; j++) {
				if (j == 3)
					break Break_Label;

				System.out.println("i = " + i + " , " + "j = " + j);
			}
		}
		System.out.println("중첩 루프 탈출");
	}

}
