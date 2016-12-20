package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.BaseContent;

/**
 * When a user want to know all the weibo or Comment(means we need to use BaseContent) which @ him.
 * 
 * @author Liu Jinfeng
 *
 */

public interface AtMeService {
	/**
	 * it needs pagination
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<BaseContent> getAtMeContentList(String userId, int pageIndex, int numberPerPage);
}
