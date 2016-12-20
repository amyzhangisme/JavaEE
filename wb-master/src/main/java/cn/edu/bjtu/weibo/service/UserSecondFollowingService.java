package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;

/**
 * This service try to help user to find potential relation between you and him
 * 
 * @author Liu Jinfeng
 *
 */

public interface UserSecondFollowingService {
	/**
	 * try to find all the users you are following and also following the target User
	 * @param userId
	 * @param targetUserId
	 * @return
	 */
	List<User> getYourFollowingUserAlsoFollowingTargetUser(String userId, String targetUserId);
}
