package cn.edu.bjtu.weibo.dao;

import java.util.List;

import cn.edu.bjtu.weibo.model.Topic;

public interface TopicDAO {
	public boolean insertNewTopic(Topic t);
	
	List<String> getUserList(String topicid);
	
	String getContent(String topicid);
	String getTopicUserNumber(String topicid);
	String getOwner(String topicid);
	String getTine(String topicid);
}
 