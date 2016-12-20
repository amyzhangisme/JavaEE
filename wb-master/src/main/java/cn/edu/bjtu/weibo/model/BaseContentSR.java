package cn.edu.bjtu.weibo.model;

public class BaseContentSR {
	private BaseContent baseContent;
	private int[] highlighIndex;
	
	public int[] getHighlighIndex() {
		return highlighIndex;
	}
	public void setHighlighIndex(int[] highlighIndex) {
		this.highlighIndex = highlighIndex;
	}
	public BaseContent getBaseContent() {
		return baseContent;
	}
	public void setBaseContent(BaseContent baseContent) {
		this.baseContent = baseContent;
	}
}
