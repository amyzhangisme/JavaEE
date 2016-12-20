package cn.edu.bjtu.weibo.service;

public interface BanedKeywordService {
	/**
	 * add baned keyword, it is used by backend
	 * @param word
	 * @return
	 */
	boolean addBanedKeyword(String word);
	/**
	 * remove baned keyword, it is used by backend
	 * @param word
	 * @return
	 */
	boolean removeBanedKeyword(String word);
}
