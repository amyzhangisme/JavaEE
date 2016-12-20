package cn.edu.bjtu.weibo.service;

/**
 * When user like some weibo or comment, he can use it.
 * @author Liu Jinfeng
 *
 */
public interface LikeActionService {
	
	/**
	 * Like weibo or comment
	 * @param userId
	 * @param weiboId
	 * @return
	 */
	boolean LikeWeiboOrCommentAction(String userId ,String weiboOrCommentId);
}
