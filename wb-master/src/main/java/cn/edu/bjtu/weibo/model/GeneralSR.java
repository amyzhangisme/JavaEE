package cn.edu.bjtu.weibo.model;

/**
 * it is a wrapper which can wrap at least 3 kinds of result.
 * Weibo, Comment, User
 * 
 * Then the web page will determine the css style and information according to the EntityType.
 * 
 * @author Liu Jinfeng
 *
 */

public class GeneralSR {
	private Object result;
	private EntityType type;
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public EntityType getType() {
		return type;
	}
	public void setType(EntityType type) {
		this.type = type;
	}
}
