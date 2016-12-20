package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.Weibo;

/**
 * This service work for listing weibos for user`s reading
 * 
 * @author Liu Jinfeng
 */

public interface WeiboListService {
	/**
	 * When a userId is specified, it will return the list of weibos
	 * and it needs pagination
	 * 
	 * @param userId
	 * @param pageIndex : start from 0 which means the first page.
	 * @param numberPerPage : for example, 20 or 30 weibos for each page.
	 * @return
	 */
	List<Weibo> getWeiboList(String userId, int pageIndex, int numberPerPage);
	
	/**
	 * When a userId is not specified, it will return the random list of weibos
	 * it depends on the algorithm you think out.
	 * and it needs pagination
	 * 
	 * @param userId
	 * @param pageIndex : start from 0 which means the first page.
	 * @param numberPerPage : for example, 20 or 30 weibos for each page.
	 * @return
	 */
	List<Weibo> getWeiboList(String pageIndex, int numberPerPage);
}
