package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.GeneralSR;

/**
 * the result will contain many types and can be extended in the future.
 * 
 * @author Liu Jinfeng
 *
 */

public interface GeneralSearchService {
	/**
	 * 
	 * @param keyword
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<GeneralSR> getGeneralSearchedResult(String keyword, int pageIndex, int numberPerPage);
}
