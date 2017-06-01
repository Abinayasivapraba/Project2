package com.niit.chatzonebe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FORUM")
public class Forum extends BaseDomain {
	@Id
	private int forumid;
	private String id;
	private Date dateadded;
	private String forummessage;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDateadded() {
		return dateadded;
	}
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	public String getForummessage() {
		return forummessage;
	}
	public void setForummessage(String forummessage) {
		this.forummessage = forummessage;
	}
	

}
