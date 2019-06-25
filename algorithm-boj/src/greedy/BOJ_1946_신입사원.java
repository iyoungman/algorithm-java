package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-24.
 * https://www.acmicpc.net/problem/1946
 * TimeOut 걸려서 해맴
 */

public class BOJ_1946_신입사원 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();//지원자 숫자
			ArrayList<Grade> grades = new ArrayList<Grade>();

			for (int j = 0; j < n; j++) {
				grades.add(new Grade(scanner.nextInt(), scanner.nextInt()));
			}

			Collections.sort(grades, new Comparator<Grade>() {
				@Override
				public int compare(Grade grade1, Grade grade2) {
					return grade1.document - grade2.document;
				}
			});

			int temp = 0;
			int result = 1;//채용
			for(int j =1; j<n;j++) {
				if(grades.get(j).interview < grades.get(temp).interview) {//순위가 더 높다면
					result++;
					temp = j;
				}
			}

			//결과 출력
			System.out.println(result);
		}
	}

	private static class Grade {
		int document;
		int interview;

		public Grade(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}
	}

}
