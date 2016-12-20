package cn.edu.bjtu.weibo.service;

/**
 * When user try to login weibo
 * @author Liu Jinfeng
 *
 */
public interface LoginService {
	/**
	 * 
	 * @param usename
	 * @param password
	 * @return
	 */
	boolean loginService(String usename, String password);
}
