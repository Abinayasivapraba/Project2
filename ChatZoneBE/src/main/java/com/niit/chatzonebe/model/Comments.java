package com.niit.chatzonebe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="COMMENTS")

public class Comments extends BaseDomain {
	@Id
	private int commentid;
	private String id;   //UserId
	private int blogid;
	private int forumid;
	private String commentsmsg;
	private Date dateadded;
	public Date getDateadded() {
		return dateadded;
	}
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	public String getCommentsmsg() {
		return commentsmsg;
	}
	public void setCommentsmsg(String commentsmsg) {
		this.commentsmsg = commentsmsg;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	
	
	
	

}
