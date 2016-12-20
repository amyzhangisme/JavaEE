package cn.edu.bjtu.weibo.service;

/**
 * When some weibo or comment contain illegal or unreal content, you can use this service to report this weibo to Admin
 * 
 * @author Liu Jinfeng
 *
 */
public interface ReportContentService {
	/**
	 * 
	 * @param userId
	 * @param weiboId
	 * @return
	 */
	boolean reportWeiboOrComment(String userId,String weiboOrCommentId);
}
