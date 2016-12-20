package cn.edu.bjtu.weibo.dao;

import java.util.List;

import cn.edu.bjtu.weibo.model.User;

public interface UserDAO {
	public boolean insertNewUser(User user);
	
	//�����û�״̬
	public boolean setState(String id, boolean s);
	
	public String getName(String id);
	public String updateName(String id);
	
	public String getPassword(String id);
	public String updatePassword(String id);
	
	public String getLocation(String id);
	public String updateLocation(String id);
	
	public String getBirthday(String id);
	public String updateBirthday(String id);
	
	public String getSex(String id);
	public String updateSex(String id);
	
	public String getLastTime(String id);
	public String updateLastName(String id);
	
	public String getWeiBoNumber(String id);
	public String updateWeiBoNumber(String id);
	
	public String getFollowerNumber(String id);
	public String updateFollowerNumber(String id);
	
	public String getFollowingNumber(String id);
	public String updateFollowingNumber(String id);
	
	
	public List<String> getFollower(String id);  //����һ��UserID��List
	public boolean insertFollower(String id);
	public boolean deleteFollower(String id);
	
	public List<String> getFollowing(String id);  //����һ��UserID��List
	public boolean insertFollowing(String id);
	public boolean deleteFollowing(String id);
	
	public List<String> getPircurlOr(String id);  //����һ��PircurlOr��List
	public List<String> getPicurlTh(String id);  //����һ��PicurlTh��List
	public boolean insertPicurl(String id); //ͬʱ����ͼƬ��ԭͼ������
	public boolean deletePicurl(String id); //ͬʱɾ��ͼƬ��ԭͼ������
	
	public List<String> getLikePicurlOr(String id);  //����һ��LikePircurlOr��List
	public List<String> getLikePicurlTh(String id);  //����һ��LikePircurlOr��List
	public boolean insertLikePicurl(String id);  //ͬʱ������޹���ͼƬ��ԭͼ������
	public boolean deleteLikePicurl(String id);  //ͬʱɾ�����޹���ͼƬ��ԭͼ������
	
	public List<String> getForwordWeibo(String id);  //����һ��WeiboID��List
	public boolean insertForwordWeibo(String id);
	public boolean deleteForwordWeibo(String id);
	
	public List<String> getLikeWeibo(String id);  //����һ��WeiboID��List
	public boolean insertLikeWeibo(String id);
	public boolean deleteLikeWeibo(String id);
	
	public List<String> getCommentWeibo(String id);  //����һ��WeiboID��List
	public boolean insertCommentWeibo(String id);
	public boolean deleteCommentWeibo(String id);
	
}
