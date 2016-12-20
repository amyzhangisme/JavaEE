package cn.edu.bjtu.weibo.service;

/**
 * When some user try to comment some words to weibo or comment
 * 
 * the action will include
 * 1 create the comment under commentList in db
 * 2 add this commentId under weibo or comment list, it depends on the place you comment on.
 * 3 increase the number of commentNumber.
 * 4 this comment is belong to you, so it will be added to your BaseContent list.
 * 
 * so we need some parameter
 * 1 who comments
 * 2 the comment entity
 * 3 which BaseContent will be attached by this comment.
 * 
 * @author Liu Jinfeng
 *
 */

public interface CommentMessageService {
	/**
	 * 
	 * @param userId
	 * @param commentId
	 * @param baseContentId : can be weibo or comment
	 * @return
	 */
	boolean CommentMessage(String userId, String commentId, String weiboOrCommentId);
}
