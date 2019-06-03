package etc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YoungMan on 2019-04-29.
 * Comparable  - 기본정렬(Arrays.sort()..)
 * Comparator  - 기본정렬 외에 다른 기준으로 정렬하고자 할때 사용, compare 메소드 오버라이드
 * compareTo() 현재 객체가 비교 객체보다 더 클경우 양수리턴, 자리를 변경하는 방식
 */

public class Comparable_Comparator {

	public static void main(String[] args) {

		String[] arr1 = {"나","가","다","라","마","바"};
		String[] arr2 = {"한글날","식목일","현충일","생일","파티","크리스마스"};

		Comparator comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};

		Arrays.sort(arr1,comparator);
		for(String s : arr1)
			System.out.println(s);
	}

}
