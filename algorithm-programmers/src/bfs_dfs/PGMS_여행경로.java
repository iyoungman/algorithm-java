package bfs_dfs;

import java.util.*;

/**
 * Created by YoungMan on 2019-12-03.
 */

public class PGMS_여행경로 {

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[][] tickets = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" } };
		System.out.println(Arrays.toString(solution(tickets)));
	}

	private static String[] solution(String[][] tickets) {
		Map<String, List<String>> ticketMaps = new HashMap<>();

		int count = 0;
		for (String[] ticket : tickets) {
			if (ticketMaps.containsKey(ticket[0])) {
				List<String> ticketValue = ticketMaps.get(ticket[0]);
				if(!ticketValue.contains(ticket[1])) {
					ticketMaps.get(ticket[0]).add(ticket[1]);
					count++;
				}
			} else {
				List<String> list = new ArrayList<>();
				list.add(ticket[1]);

				ticketMaps.put(ticket[0], list);
				count++;
			}
		}

		LinkedList<String> list = new LinkedList<>();
		list.offer("ICN");

		int i = 0;
		String[] result = new String[count + 1];
		while (list.size() != 0) {
			String current = list.poll();
			result[i++] = current;
			if(i == count + 1) {
				break;
			}

			List<String> nexts = ticketMaps.get(current);
			if (nexts.size() > 1) {
				Collections.sort(nexts);
				list.add(nexts.remove(0));
			} else if (nexts.size() == 1) {
				list.add(nexts.remove(0));
			}
		}

		return result;
	}
}
