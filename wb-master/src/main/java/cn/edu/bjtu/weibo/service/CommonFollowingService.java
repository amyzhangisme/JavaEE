package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;

/**
 * Try to find some relationship between two users.
 * 
 * @author Liu Jinfeng
 *
 */

public interface CommonFollowingService {
	/**
	 * it needs pagination
	 * @param userId
	 * @param otherUserId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<User> getCommonFollowingUserList(String userId,String otherUserId, int pageIndex, int numberPerPage);
}
