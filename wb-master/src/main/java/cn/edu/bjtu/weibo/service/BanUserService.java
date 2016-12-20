package cn.edu.bjtu.weibo.service;

/**
 * When one user A ban another user B, then the user won`t see any weibo from B
 * here, ban means the ban action
 * 
 * @author Liu Jinfeng
 *
 */
public interface BanUserService {
	/**
	 * The action when userId ban banedUserId
	 * @param userId
	 * @param banedUserId
	 * @return
	 */
	boolean banUser(String userId, String banedUserId);
	/**
	 * The action when userId unban banedUserId
	 * @param userId
	 * @param banedUserId
	 * @return
	 */
	boolean unbanUser(String userId, String banedUserId);
}
