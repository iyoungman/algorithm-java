package etc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by YoungMan on 2019-04-23.
 * Collections 의 Max,Min
 */

public class Collections_MaxMin {

	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(1, 3, 6, 2, 4, 2, 3, 5);
		int max = Collections.max(num);
		System.out.println(max);
	}
}
