package cn.edu.bjtu.weibo.service;

/**
 * When user try to know all his attention users number, it will use this.
 * usually, it will show automatically besides your profile, it is a high frequency usage
 * @author Liu Jinfeng
 *
 */

public interface FollowingNumberService {
	/**
	 * @param userId
	 * @return
	 */
	int getFollowingNumber(String userId);
}
