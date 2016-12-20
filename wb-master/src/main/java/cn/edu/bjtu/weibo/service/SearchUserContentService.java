package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.BaseContentSR;

/**
 * Search something in some user`s weibo content.
 * 
 * @author Liu Jinfeng
 *
 */
public interface SearchUserContentService {
	/**
	 * it needs pagination
	 * @param userId
	 * @return
	 */
	List<BaseContentSR> getSearchedUserWeiboList(String userId, String keyword, int pageIndex, int numberPerPage);
}
