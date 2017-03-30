package com.fengyun.web.util;

import org.apache.commons.lang.math.RandomUtils;

public class RandomUtil {

	public static int random(Integer from, Integer to) {
		return RandomUtils.nextInt(to - from + 1) + from;
	}

	/**
	 * 根据权重列表随机命中某一权重
	 * 
	 * @param weights
	 *            :权重列表
	 * @param totalWeight
	 *            :总重权(<=0时从权重列表重新累加)
	 * @return:index:命中的权重对应的下标
	 */
	public static int getRandomIndex(int[] weights, int totalWeight) {
		if (weights.length > 1) {
			if (totalWeight <= 0) {
				for (int weight : weights)
					totalWeight += weight;
			}
			int rand = RandomUtils.nextInt(totalWeight);
			int start = 0, end = 0;
			for (int i = 0; i < weights.length; i++) {
				start = end;
				end = start + weights[i];
				if (rand >= start && rand < end)
					return i;
			}
		}
		return 0;
	}
}
