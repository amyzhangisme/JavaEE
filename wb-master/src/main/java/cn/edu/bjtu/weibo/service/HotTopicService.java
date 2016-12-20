package cn.edu.bjtu.weibo.service;

import java.util.List;

import cn.edu.bjtu.weibo.model.Topic;

/**
 * Try to display popular topic for you. topic means the content between two #
 * 
 * @author Liu Jinfeng
 *
 */

public interface HotTopicService {
	/**
	 * 
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<Topic> HotTopic(int pageIndex, int numberPerPage);
}
