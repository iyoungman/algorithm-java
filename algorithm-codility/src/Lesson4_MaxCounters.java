import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-19.
 */

public class Lesson4_MaxCounters {

    public static void main(String[] args) {
        int n = 5;
        int[] a = {3, 4, 4, 6, 1, 4, 4};

        int[] result = solution(n, a);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int n, int[] a) {
        int[] counters = new int[n];
        int max = 0;

        for (int value : a) {
            if (value >= 1 && value <= n) {//increase(X
                int next = counters[value - 1] + 1;
                counters[value - 1] = next;
                max = max < next ? next : max;
            } else {//max counter
                for (int i = 0; i < counters.length; i++) {
                    counters[i] = max;
                }
            }
        }

        return counters;
    }
}
