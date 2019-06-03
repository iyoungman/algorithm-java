package kakao_code_festival_2018;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-06.
 */

public class BOJ_15953_상금헌터 {

	public static void main(String[] args) {

		List<RewardInfo> firstRewardInfoList = Arrays.asList(
				new RewardInfo(500, 1),
				new RewardInfo(300, 1 + 2),
				new RewardInfo(200, 1 + 2 + 3),
				new RewardInfo(50, 1 + 2 + 3 + 4),
				new RewardInfo(30, 1 + 2 + 3 + 4 + 5),
				new RewardInfo(10, 1 + 2 + 3 + 4 + 5 + 6)
		);

		List<RewardInfo> secondRewardInfoList = Arrays.asList(
				new RewardInfo(512, 1),
				new RewardInfo(256, 1 + 2),
				new RewardInfo(128, 1 + 2 + 4),
				new RewardInfo(64, 1 + 2 + 4 + 8),
				new RewardInfo(32, 1 + 2 + 4 + 8 + 16)
		);

		int rankFirst = 13;
		int rankSecond = 19;
		int totalReward = 0;

		for (RewardInfo rewardInfo : firstRewardInfoList) {
			if (rankFirst < rewardInfo.getMaxRank()) {
				totalReward = totalReward + rewardInfo.getReward();
				break;
			}
		}

		for (RewardInfo rewardInfo : secondRewardInfoList) {
			if (rankSecond < rewardInfo.getMaxRank()) {
				totalReward = totalReward + rewardInfo.getReward();
				break;
			}
		}

		System.out.println(totalReward);
	}
}

class RewardInfo {
	private int reward;
	private int maxRank;

	public RewardInfo(int reward, int maxRank) {
		this.reward = reward;
		this.maxRank = maxRank;
	}

	public int getReward() {
		return reward;
	}

	public int getMaxRank() {
		return maxRank;
	}
}
