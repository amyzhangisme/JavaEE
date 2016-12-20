package cn.edu.bjtu.weibo.service;

/**
 * When a user dislike some weibo, he can ban the weibo, and he won`t see this weibo after he refresh the weibo list page.
 * 
 * @author Liu Jinfeng
 *
 */

public interface BanWeiboService {
	/**
	 * 
	 * @param userId : the user who want to ban some weibo he dislike
	 * @param weiboId : the baned weibo Id
	 * @return
	 */
	boolean banWeibo(String userId,String weiboId);
	/**
	 * the reverse operation for BanWeibo
	 * @param userId : the user who want to ban some weibo he dislike
	 * @param weiboId : the baned weibo Id
	 * @return
	 */
	boolean unbanWeibo(String userId, String weiboId);
}
