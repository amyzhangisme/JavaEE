package cn.edu.bjtu.weibo.service;

/**
 * Usually it will show automatically beside the user profile.
 * 
 * @author Liu Jinfeng
 *
 */

public interface FollowerNumberService {
	/**
	 * 
	 * @param userId
	 * @return
	 */
	int getFollowerNumber(String userId);
}
