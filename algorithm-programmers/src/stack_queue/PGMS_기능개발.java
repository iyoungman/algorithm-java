package stack_queue;

import java.util.ArrayList;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_기능개발 {

	public static void main(String[] args) {

	}

	private static int[] solution(int[] progresses, int[] speeds) {
		int size = progresses.length;
		int[] finish = new int[size];

		for (int i = 0; i < size; i++) {
			int remain = 100 - progresses[i];
			int sp = speeds[i];

			int count = 0;
			if (remain % sp != 0) {
				count = remain / sp + 1;
			} else {
				count = remain / sp;
			}
			finish[i] = count;
		}

		ArrayList<Integer> result = new ArrayList<>();
		int temp = 1;
		for (int i = 0; i < finish.length; i = i + temp) {
			temp = 1;
			for (int j = i + 1; j < finish.length; j++) {
				if(finish[i] >= finish[j]) {
					temp++;
				} else {
					break;
				}
			}
			result.add(temp);
			if(i + temp > finish.length - 1) {
				break;
			}
		}

		int[] resu = new int[result.size()];
		int i = 0;
		for(int index : result) {
			resu[i++] = index;
		}

		return resu;
	}
}
