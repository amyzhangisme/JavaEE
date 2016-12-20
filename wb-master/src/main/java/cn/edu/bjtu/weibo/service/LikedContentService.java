package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.BaseContent;

/**
 * List all the weibo or comment you 'like'
 * 
 * @author Liu Jinfeng
 *
 */

public interface LikedContentService {
	/**
	 * 
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<BaseContent> getLikedContentList(String userId, int pageIndex, int numberPerPage);
}
