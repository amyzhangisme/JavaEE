package cn.edu.bjtu.weibo.model;

public class UserSR {
	private User user;
	private int[] highlightIndex;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int[] getHighlightIndex() {
		return highlightIndex;
	}
	public void setHighlightIndex(int[] highlightIndex) {
		this.highlightIndex = highlightIndex;
	}
}
