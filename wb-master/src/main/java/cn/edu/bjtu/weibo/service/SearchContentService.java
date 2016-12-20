package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.BaseContentSR;

/**
 * When the user search some keyword in the weibo content.
 * 
 * @author Liu Jinfeng
 *
 */
public interface SearchContentService {
	/**
	 * it needs pagination
	 * @param keyword
	 * @return
	 */
	List<BaseContentSR> getSearchedWeiboList(String keyword, int pageIndex, int numberPerPage);
}
