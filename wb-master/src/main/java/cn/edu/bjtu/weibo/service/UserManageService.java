package cn.edu.bjtu.weibo.service;

/**
 * when the admin manage the user, it can ban some user or unban.
 * 
 */
public interface UserManageService {
	/**
	 * ban a user by userid
	 * @param userid
	 */
	boolean banUser(String userId);
	boolean unBanUser(String userId);
}
