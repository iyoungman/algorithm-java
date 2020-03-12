package binary_search;

import java.util.Arrays;

/**
 * Created by YoungMan on 2020-03-12.
 */

public class PGMS_징검다리 {

      public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        System.out.println(solution(distance, rocks, n));
    }

    private static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int mid = 0;

        int result = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            int count = getCount(mid, rocks, distance);
            if(count > n) {//최솟값이 너무 클때
                right = mid -1;
            } else {//최솟값이 너무 작을 때, 최솟값 중 최대값을 구하는 것이므로 count < n이 포함되도 괜찮다 어차피 count <= n의 max 값이 답이다
                left = mid + 1;
                result = Math.max(result, mid);
            }
        }

        return result;
    }

    private static int getCount(int mid, int[] rocks, int end) {
        int cur = 0;
        int removeCount = 0;
        for (int i = 0; i < rocks.length; i++) {
            int sub = rocks[i] - cur;
            if (sub < mid) {//최솟값보다 작으면 제거
                removeCount++;
                continue;
            }
            cur = rocks[i];//제거하지 않으면 바위의 거리를 구하기 위해 index 저장
        }

        if (end - cur < mid) removeCount++;

        return removeCount;
    }

}
