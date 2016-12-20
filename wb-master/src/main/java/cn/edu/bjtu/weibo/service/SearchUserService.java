package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.UserSR;

/**
 * When user want to search some user according to the given name
 * 
 * @author Liu Jinfeng
 *
 */

public interface SearchUserService {
	/**
	 * it needs pagination
	 * @param username
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<UserSR> getSearchedUserList(String username, int pageIndex, int numberPerPage);
}
