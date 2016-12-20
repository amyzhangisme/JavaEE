package cn.edu.bjtu.weibo.service;

/**
 * When some action happened, notify the user in his message box
 * 
 * @author Liu Jinfeng
 *
 */

public interface MessageToMeService {
	/**
	 * when a user @ another user, it will alter that user.
	 * @param fromUserId
	 * @param toUserId
	 * @return
	 */
	boolean atMeInform(String fromUserId ,String toUserId);
	/**
	 * When a user comment another user`s weibo or comment, that user should be notified
	 * @param fromUserId
	 * @param toUserId
	 * @param commentId
	 * @param weiboId
	 * @return
	 */
	boolean commentMyWeiboOrCommentInform(String fromUserId, String toUserId, String commentId, String weiboOrCommentId);
	/**
	 * When a user like some user`s weibo or comments, that user should be notified
	 * @param fromUserId
	 * @param toUserId
	 * @param weiboId
	 * @return
	 */
	boolean likeMyWeiboOrCommentInform(int fromUserId, int toUserId, int weiboOrCommentId);
}
