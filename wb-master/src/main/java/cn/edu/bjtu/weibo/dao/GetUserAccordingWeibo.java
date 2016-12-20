package cn.edu.bjtu.weibo.dao;

import cn.edu.bjtu.weibo.model.User;
import cn.edu.bjtu.weibo.model.Weibo;

public interface GetUserAccordingWeibo {

	public User getuser(Weibo weibo);
	
}
