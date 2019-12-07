package greedy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-17.
 * https://www.acmicpc.net/problem/2529
 */

public class BOJ_2529_부등호_2 {

	private static int k;//부등호 개수
	private static char[] inEqualities;//부등호 저장
	private static LinkedList<Integer> nums;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		inEqualities = new char[k];
		nums = new LinkedList<Integer>();

		//부등호 입력
		for (int i = 0; i < k; i++) {
			char inEquality = scanner.next().charAt(0);
			inEqualities[i] = inEquality;
			nums.add(i);
		}


//		출력
		System.out.println(getMax());
		System.out.println(getMin());
	}

//	private static int getMax() {
//
//	}

	private static int[] getMin() {
		int start = inEqualities[0] == '<' ? 0 : 1;
		int[] numbers = new int[k + 1];
		numbers[0] = start;

		for(int i = 1; i < k + 1; i++) {
//			int next = 0;
			if(inEqualities[i-1] == '<') {
//				next = nums.stream()
//						.min(Integer::compareTo)
//						.get();
				numbers[i] = numbers[i-1] + 2;
			} else {
				numbers[i] = numbers[i-1] -1;
			}
		}

		return numbers;
	}

	private static int[] getMax() {
		int start = inEqualities[0] == '<' ? 8 : 9;
		int[] numbers = new int[k + 1];
		numbers[0] = start;

		for(int i = 1; i < k + 1; i++) {
//			int next = 0;
			if(inEqualities[i-1] == '<') {
//				next = nums.stream()
//						.min(Integer::compareTo)
//						.get();
				numbers[i] = numbers[i-1] + 1;
			} else {
				numbers[i] = numbers[i-1] -2;
			}
		}

		return numbers;
	}

//	private static String getMin(int smaller) {
//		int start = smaller;//시작 숫자
//		removeIndex(start);
//		String result = start + "";
//
//		for(int i = 0; i < k; i++) {
//			int next = 0;
//			int before = start;
//			if(inEqualities[i] == '<') {
//				next = nums.stream()
//						.filter(index -> index > before)
//						.min(Integer::compareTo)
//						.get();
//			} else {
//				next = nums.stream()
//						.filter(index -> index < before)
//						.min(Integer::compareTo)
//						.get();
//			}
//
//			result = result + next;
//			start = next;
//			removeIndex(next);
//		}
//
//		return result;
//	}
//
//
//
	private static void removeIndex(int num) {
		int removeIndex = nums.indexOf(num);
		nums.remove(removeIndex);
	}


}
