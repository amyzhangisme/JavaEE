package cn.edu.bjtu.weibo.service;

/**
 * When some user publish some thing illegal, you can use it to report this user to the admin.
 * 
 * @author Liu Jinfeng
 *
 */

public interface ReportUserService {
	/**
	 * 
	 * @param userId
	 * @param reportedUserId
	 * @return
	 */
	boolean ReportUser(String userId, String reportedUserId);
}
