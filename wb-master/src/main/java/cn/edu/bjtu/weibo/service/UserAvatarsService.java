package cn.edu.bjtu.weibo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.weibo.model.Picture;

/**
 * User avatar related service
 * @author Liu Jinfeng
 *
 */

public interface UserAvatarsService {
	/**
	 * Display all the Avatar pic belong to some user
	 * @param userId
	 * @param pageIndex
	 * @param numberPerPage
	 * @return
	 */
	List<Picture> getUserAvatarList(String userId, int pageIndex, int numberPerPage);
	/**
	 * upload user avatar, it can call pictureservice.
	 * @param userId
	 * @param multipartFile
	 * @return
	 */
	boolean uploadUserAvatar(String userId, MultipartFile multipartFile);
}
