package cn.edu.bjtu.weibo.dao;

import java.util.List;

public interface WeiboDAO {
	public String getOwner(String weiboId);
	
	public String getContent(String weiboId);
	public boolean updateContent(String weiboId, String content);
	
	public String getTime(String weiboId);
	
	public List<String> getWeiboPicurlOr(String weiboId);
	
	public List<String> getWeiboPicurlTh(String weiboId);
	
	public String getLikeNumber(String weiboId);
	
	public String getCommentNumber(String weiboId);
	
	public String getForwardNumber(String weiboId);
	
	public List<String> getLikeLIst(String weiboId);
	
	public List<String> getForwardList(String weiboId);
	
	public List<String> getCommentList(String weiboId);
}
