package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by YoungMan on 2019-09-30.
 * 1. 순열 집합을 구한 후 해당 수가 소수인지
 * 2. 가장 큰 값을 구한 후 해당 숫자까지의 소수
 */

public class PGMS_소수찾기 {

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}

	private static int solution(String numbers) {
		int[] nums = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			nums[i] = numbers.charAt(i) - '0';
		}

		Arrays.sort(nums);

		StringBuilder maxNumBuilder = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) {
			maxNumBuilder.append(nums[i]);
		}

		ArrayList<Integer> primeList = getPrimes(Integer.parseInt(maxNumBuilder.toString()));
		int[] count = getNumCount(nums);

		int result = 0;
		for (int prime : primeList) {
			if (isPossible(prime, count)) {
				result++;
			}
		}

		return result;
	}

	//에라토스의 체
	private static ArrayList<Integer> getPrimes(int maxNum) {
		boolean[] isPrime = new boolean[maxNum + 1];

		//모두 소수로 셋팅
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		//소수가 아닌 것을 거른다
		for (int i = 2; i <= maxNum; i++) {
			for (int j = 2; i * j <= maxNum; j++) {//특정 수의 배수를 제거한다
				isPrime[i * j] = false;
			}
		}

		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primeList.add(i);
			}
		}
		return primeList;
	}

	private static int[] getNumCount(int[] num) {
		int[] count = new int[10];
		for (int index : num) {
			count[index] = count[index] + 1;
		}
		return count;
	}

	private static boolean isPossible(int prime, int[] count) {
		count = Arrays.copyOf(count, count.length);
		char[] primeArrays = String.valueOf(prime).toCharArray();

		for (int i = 0; i < primeArrays.length; i++) {
			int num = primeArrays[i] - '0';
			count[num] = count[num] - 1;
			if (count[num] < 0) {
				return false;
			}
		}
		return true;
	}

}
