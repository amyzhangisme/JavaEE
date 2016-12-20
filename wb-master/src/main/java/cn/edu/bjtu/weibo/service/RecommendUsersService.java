package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;

/**
 * Recommend some user for a user, it depends on your recommendation algorithm.
 * 
 * @author Liu Jinfeng
 *
 */

public interface RecommendUsersService {
	/**
	 * it needs pagination
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<User> getRecommendUserList(String userId, int pageIndex, int numberPerPage);
}
