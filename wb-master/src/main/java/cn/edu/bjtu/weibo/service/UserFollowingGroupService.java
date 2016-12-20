package cn.edu.bjtu.weibo.service;

/**
 * Use this service, you can classify your interested user you want to follow.
 * 
 * @author Liu Jinfeng
 *
 */

public interface UserFollowingGroupService {
	/**
	 * When the user want to follow another user, he can put that user into a new created group
	 * @param userId
	 * @param groupName
	 * @return
	 */
	boolean andToNewGroup(String userId, String otherUserId, String groupName);
	/**
	 * Add some user to existed group.
	 * @param userId
	 * @param otherUserId
	 * @param groupId
	 * @return
	 */
	boolean addToExistedGroup(String userId, String otherUserId, String groupId);
	/**
	 * Get all group names for display.
	 * @param userId
	 * @return
	 */
	boolean getGroupNames(String userId);
	/**
	 * Get all users belong to some group
	 * @param groupId
	 * @return
	 */
	boolean getUsersByGroup(String groupId);
}
