package cn.edu.bjtu.weibo.dao;

public interface CommentDAO {
	String getComment(String commentid);
	String getTopicUserNumber(String commentid);
	String getOwner(String commentid);
	String getTime(String commentid);
}
