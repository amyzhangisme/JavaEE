package cn.edu.bjtu.weibo.service;

/**
 * Check if weibo contains baned keywords.
 * 
 * @author Liu Jinfeng
 *
 */

public interface FilterBanedKeywordsService {
	/**
	 * check if a weiboContent contain baned keyword, if true, this weibo won`t be sended.
	 * and also inform user to notice.
	 * @param word
	 * @return
	 */
	boolean isBanedKeywordInside(String weiboContent);
}
