package cn.edu.bjtu.weibo.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import cn.edu.bjtu.weibo.model.Picture;

/**
 * Weibo`s pictures service.
 * 
 * for example, currently, one weibo have most 9 pictures with it.
 * 
 * @author Liu Jinfeng
 *
 */
public interface WeiboPictureServie {
	/**
	 * Get all the pictures belong to some weibo
	 * @param weiboId
	 * @return
	 */
	List<Picture> getWeiboPictureList(String weiboId);
	
	/**
	 * Upload pictures for weibo,it can call pictureservice.
	 * @param weiboId
	 * @param multipartFile
	 * @return
	 */
	boolean uploadWeiboPicture(String weiboId, MultipartFile multipartFile);
}
