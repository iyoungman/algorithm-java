package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-16.
 * https://www.acmicpc.net/problem/10825
 */

public class BOJ_10825_국영수 {

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//학생 수
		scanner.nextLine();
		Student[] students = new Student[n];

		//이름, 점수 입력
		for (int i = 0; i < n; i++) {
			String[] line = scanner.nextLine().split(" ");
			Student newStudent = new Student(line[0], stoi(line[1]), stoi(line[2]), stoi(line[3]));
			students[i] = newStudent;
		}

		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math) {
					return o1.name.compareTo(o2.name);
				} else if (o1.korean == o2.korean && o1.english == o2.english) {
					return Integer.compare(o2.math, o1.math);//내림차순
				} else if (o1.korean == o2.korean) {
					return Integer.compare(o1.english, o2.english);//오름차순
				} else {
					return Integer.compare(o2.korean, o1.korean);//내림차순
				}
			}
		});

		//결과 출력
		for (Student student : students) {
			System.out.println(student.name);
		}
	}
}

class Student {
	String name;
	int korean;
	int english;
	int math;

	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}
