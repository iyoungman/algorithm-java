package kakao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-08-05.
 * 중복되지 않은 값만 구하면 간단하다
 */

public class Kakao2017_Test3_직사각형좌표구하기 {

	public static void main(String[] args) {
		int[][] test1 = {{1, 4}, {3, 4}, {3, 10}};
		int[][] test2 = {{1, 1}, {2, 2}, {1, 2}};

		//결과 출력
		int[] result = getCoordinate(test2);
		System.out.println(Arrays.toString(result));
	}

	private static int[] getCoordinate(int[][] square) {
		List<Integer> xList = getXorY(square, 0);
		List<Integer> yList = getXorY(square, 1);

		int result[] = new int[2];
		for (int i = 1; i < 3; i++) {
			if(xList.get(i) != xList.get(i - 1)) {
				result[0] = (i == 1) ? xList.get(0) : xList.get(2);
			}
			if(yList.get(i) != yList.get(i - 1)) {
				result[1] = (i == 1) ? yList.get(0) : yList.get(2);
			}
		}

		return result;
	}

	private static List<Integer> getXorY(int[][] square, int code) {
		return Arrays.stream(square)
				.map(i -> i[code])
				.sorted()
				.collect(Collectors.toList());
	}

}
