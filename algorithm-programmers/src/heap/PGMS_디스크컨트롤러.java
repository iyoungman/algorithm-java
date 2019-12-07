package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by YoungMan on 2019-11-06.
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 시간의 흐름에 따라 우선순위 큐에 넣는 것을 고려하기 보다는
 * 우선순위 큐에 넣는 것을 기준으로 Time을 체크한다
 */

public class PGMS_디스크컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};
		System.out.println(solution(jobs));
	}

	private static int solution(int[][] jobs) {
		//주어진 job 이 요청 시간 대로 정렬되어있다는 보장이 없다
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		Job[] jobList = new Job[jobs.length];
		int i = 0;
		for (int[] job : jobs) {
			jobList[i++] = new Job(job[0], job[1]);
		}

		PriorityQueue<Job> priorityQueue = new PriorityQueue<>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if (o1.run == o2.run) {
					return Integer.compare(o1.request, o2.request);
				}
				return Integer.compare(o1.run, o2.run);
			}
		});

		int currentTime = 0;
		int tempIndex = 0;
		int allTime = 0;
		int checkCount = 0;
		while (checkCount < jobList.length) {
			//추가 작업, 추가가 우선이다
			for (int k = tempIndex; k < jobList.length; k++) {
				//현재 Time 보다 요청 Time 이 작은것
				if (jobList[k].request <= currentTime) {
					priorityQueue.add(jobList[k]);
					tempIndex++;
				} else {
					break;
				}
			}

			//시간 작업
			if (!priorityQueue.isEmpty()) {
				Job job = priorityQueue.poll();
				currentTime = currentTime + job.run;

				allTime = allTime + (currentTime - job.request);
				checkCount++;
			} else {
				currentTime++;
			}
		}

		return (int) (allTime / jobList.length);
	}


}

class Job {
	int request;
	int run;

	Job(int request, int run) {
		this.request = request;
		this.run = run;
	}
}
