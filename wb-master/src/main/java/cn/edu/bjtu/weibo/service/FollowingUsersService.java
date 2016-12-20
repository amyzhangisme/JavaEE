package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;
/**
 * When user try to view all the interested user for him
 * 
 * @author Liu Jinfeng
 *
 */
public interface FollowingUsersService {
	/**
	 * 
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return the userId collection for more flexible
	 */
	List<String> getFollowingUserIdList(String userId, int pageIndex, int numberPerPage);
	/**
	 * 
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return the user which only use for display all current user`s interest users
	 */
	List<User> getFollowingUserList(String userId, int pageIndex, int numberPerPage);
}
