package stackqueue;

/**
 * Created by YoungMan on 2019-04-28.
 * 배열이 0으로 초기화 되어 있기 때문에 j가 0일때를 고려할 필요 없다.
 */

public class PGMS_탑 {

	public static void main(String[] args) {

		int[] heights = {6, 9, 5, 7, 4};
		int[] results = solution(heights);

		for(int result : results) {
			System.out.println(result);
		}
	}

	static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = 1; i < heights.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if(heights[j] > heights[i]) {
					answer[i] = j + 1;//~번째 저장
					break;
				}
			}
		}
		return answer;
	}
}
