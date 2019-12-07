package sort;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-11-16.
 * https://www.acmicpc.net/problem/2343
 */

public class BOJ_2343_기타레슨 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }

        System.out.println(getSize(time, m));
    }

    private static int getSize(int[] time, int m) {
        int last = 0;
        for (int index : time) {
            last = last + index;
        }

        int result = Integer.MAX_VALUE;
        int first = 1;
        int mid = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            boolean isPossible = calculate(mid, time, m);//m개 이상 가능할 때
            if (isPossible) {
                last = mid - 1;//가능한 블루레이의 크기 최소를 구하기 위해 범위를 줄인다
                result = Math.min(result, mid);
            } else {//블루레이 크기가 너무 작아서 개수가 너무 많을 때
                first = mid + 1;//블루레이 크기를 늘린다
            }
        }

        return result;
    }

    private static boolean calculate(int mid, int[] time, int m) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] > mid) {//곡 하나가 녹음시간보다 큰 경우
                return false;
            }

            temp = temp + time[i];
            if (temp > mid) {
                count++;
                temp = time[i];
            }
        }

        return count + 1 <= m;//해당 경우 mid가 크다는 의미이므로 mid를 작게 해야한다
    }
}
