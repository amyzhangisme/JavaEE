package cn.edu.bjtu.weibo.service;

/**
 * Register a new user, make sure the password should be encrypted
 * 
 * @author Liu Jinfeng
 *
 */

public interface RegisterService {
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	boolean registerNewUser(String username, String password);
}
