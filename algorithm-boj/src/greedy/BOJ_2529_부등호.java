package greedy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-17.
 * https://www.acmicpc.net/problem/2529
 */

public class BOJ_2529_부등호 {

	private static int k;//부등호 개수
	private static char[] inEqualities;//부등호 저장
	private static LinkedList<Integer> nums;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		inEqualities = new char[k];
		int bigger = 0;//자신보다 큰수 <
		int smaller = 0;//자신보다 작은수 >
		nums = new LinkedList<Integer>();

		//부등호 입력
		for (int i = 0; i < k; i++) {
			char inEquality = scanner.next().charAt(0);
			inEqualities[i] = inEquality;
			nums.add(i);

			if(inEquality == '<') {
				bigger++;
				continue;
			}
			smaller++;
		}

		//출력
//		System.out.println(getMax());
		System.out.println(getMin(smaller));
	}

//	private static int getMax() {
//
//	}

	private static String getMin(int smaller) {
		int start = smaller;//시작숫자
		int left = 0;
		String result = start + "";

		for(int i = 0; i < k; i++) {
			int next = 0;
			if(inEqualities[i] == '<') {
				next = start + 1;
				start++;
			} else {
				next = left;
				left = left + 1;
			}
			result = result + next;
		}

		return result;
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
//	private static void removeIndex(int num) {
//		int removeIndex = nums.indexOf(num);
//		nums.remove(removeIndex);
//	}


}
