package cn.edu.bjtu.weibo.dao;

import java.util.List;

import cn.edu.bjtu.weibo.model.Weibo;

public interface GetWeiboAccordingTime {
	/**
	 * 
	 * @param starttime 当前的时间（不用动，我传给你就好啦）
	 * @param endtime 一小时前的时间 不用动，我传给你就好啦）
	 * @return
	 */
	List<Weibo> getWeiboList(String starttime,String endtime);
}
