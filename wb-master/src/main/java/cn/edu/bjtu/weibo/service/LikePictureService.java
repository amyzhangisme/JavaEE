package cn.edu.bjtu.weibo.service;

/**
 * When a user want to show his interest for some picture, he can use this service.
 * 
 * @author Liu Jinfeng
 *
 */
public interface LikePictureService {
	/**
	 * 
	 * @param userId
	 * @param picId
	 * @return
	 */
	boolean LikePictureAction(String userId ,String picId);
}
