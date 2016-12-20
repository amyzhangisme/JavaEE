package cn.edu.bjtu.weibo.service;

import cn.edu.bjtu.weibo.model.User;

/**
 * All the operations when user try to add or modify the person`s information
 * 
 * @author Liu Jinfeng
 *
 */

public interface UserProfileService {
	/**
	 * Create a new user
	 * @param user
	 * @return
	 */
	boolean createNewUser(User user);
	/**
	 * Get a user profile
	 * @param userId
	 * @return
	 */
	User getUserProfile(String userId);
	/**
	 * Update user name
	 * @param userId
	 * @param userName
	 * @return
	 */
	boolean updateUserName(String userId, String userName);
	/**
	 * Update user introduction
	 * @param userId
	 * @param introduction
	 * @return
	 */
	boolean updateUserIntroduction(String userId, String introduction);
	/**
	 * Update user phone number
	 * @param userId
	 * @param phoneNumber
	 * @return
	 */
	boolean updateUserPhoneNumber(String userId, String phoneNumber);
	/**
	 * Update user sex
	 * @param userId
	 * @param sex
	 * @return
	 */
	boolean updateUserSex(String userId, String sex);
	/**
	 * Update user age
	 * @param userId
	 * @param age
	 * @return
	 */
	boolean updateUserAge(String userId, String age);
	/**
	 * Update user birthday
	 * @param userId
	 * @param birthday
	 * @return
	 */
	boolean updateUserBirthday(String userId, String birthday);
	/**
	 * Update user location
	 * @param userId
	 * @param location
	 * @return
	 */
	boolean updateUserLocation(String userId, String location);
	/**
	 * Update user email address
	 * @param userId
	 * @param email
	 * @return
	 */
	boolean updateUserEmail(String userId, String email);
	/**
	 * Update user qq
	 * @param userId
	 * @param qq
	 * @return
	 */
	boolean updateUserQQ(String userId, String qq);
	/**
	 * Update user education
	 * @param userId
	 * @param education
	 * @return
	 */
	boolean updateUserEducation(String userId, String education);
	/**
	 * Update last weibo Id
	 * @param userId
	 * @param lastWeiboId
	 * @return
	 */
	boolean updateUserLastWeiboId(String userId, String lastWeiboId);
}
