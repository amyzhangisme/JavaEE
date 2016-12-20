package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;

/**
 * When a use want to see all his fans
 * 
 * @author Liu Jinfeng
 *
 */

public interface FollowerUsersService {
	/**
	 * it needs pagination
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<String> getFollowerUserIdList(String userId, int pageIndex, int numberPerPage);
	
	/**
	 * it needs pagination
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<User> getFollowerUserList(String userId, int pageIndex, int numberPerPage);
}
