import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-19.
 */

public class Lesson4_MaxCounters2 {

    public static void main(String[] args) {
        int n = 5;
        int[] a = {3, 4, 4, 6, 1, 4, 4};

        int[] result = solution(n, a);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int n, int[] a) {
        int[] counters = new int[n];
        int max = 0;
        int lastCallMax = 0;

        for (int value : a) {
            if (value >= 1 && value <= n) {//increase(X
                int next = 0;
                if (counters[value - 1] < lastCallMax) {
                    next = lastCallMax + 1;
                    counters[value - 1] = next;
                } else {
                    next = counters[value - 1] + 1;
                    counters[value - 1] = next;
                }
                max = max < next ? next : max;
            } else {//max counter
                lastCallMax = max;
            }
        }

        for (int i = 0; i < n; i++) {//lastCallMax 보다 작은 것들만 체크
            if (counters[i] < lastCallMax) {
                counters[i] = lastCallMax;
            }
        }

        return counters;
    }
}
