package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.Weibo;

/**
 * Try to help find popular weibo belong to some user
 * 
 * @author Liu Jinfeng
 *
 */

public interface HotUserWeiboService {
	/**
	 * 
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<Weibo> HotUserWeiboList(String userId, int pageIndex, int numberPerPage);
}
