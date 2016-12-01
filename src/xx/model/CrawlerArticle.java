package xx.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class CrawlerArticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String brief;
	private String content;
	private Timestamp insertTime;
	private Integer baiduPost;

	// Constructors

	/** default constructor */
	public CrawlerArticle() {
	}

	/** full constructor */
	public CrawlerArticle(String title, String brief, String content) {
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public Integer getBaiduPost() {
		return baiduPost;
	}

	public void setBaiduPost(Integer baiduPost) {
		this.baiduPost = baiduPost;
	}
}