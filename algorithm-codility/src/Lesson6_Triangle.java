import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-19.
 */

public class Lesson6_Triangle {

    public static void main(String[] args) {
        int[] a = {10, 2, 5, 1, 8, 20};
        System.out.println(solution(a));
    }

    private static int solution(int[] a) {
        Arrays.sort(a);

        for (int i = 0; i + 2 < a.length; i++) {
            if (a[i] + a[i + 1] > a[i + 2] && a[i] + a[i + 2] > a[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
