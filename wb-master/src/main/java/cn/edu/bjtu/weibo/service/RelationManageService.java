package cn.edu.bjtu.weibo.service;

/**
 * Manage your relation with other users
 * there are 3 actions you can do
 * 1 follow some user you are interested.
 * 2 unfollow some user when you are boring
 * 3 some user follow you but you dislike be followed by him, you can remove it from your fans list
 * 
 * @author Liu Jinfeng
 *
 */

public interface RelationManageService {
	/**
	 * you want to follow someone
	 * @param userId
	 * @param userIdfollowed
	 * @return
	 */
	boolean followAction(String userId, String followedUserId);
	/**
	 * you want to unfollow someone
	 * @param userId
	 * @param userIdunfollowed
	 * @return
	 */
	boolean unfollowAction(String userId, String unfollowedUserId);
	/**
	 * the one who follow you, but you don`t want him to be your fans, you can remove him.
	 * @param userId
	 * @param userIddelete
	 * @return
	 */
	boolean removeFansAction(String userId, String removedUserId);
}
