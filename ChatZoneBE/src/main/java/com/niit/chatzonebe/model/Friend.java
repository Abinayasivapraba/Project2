package com.niit.chatzonebe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Friend {
	@Id
	private int fid;  //friendid
    private String id;   //userid
    private String status;
    private char isonline;
    private Date lastseen;   //lastseentime
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public char getIsonline() {
		return isonline;
	}
	public void setIsonline(char isonline) {
		this.isonline = isonline;
	}
	public Date getLastseen() {
		return lastseen;
	}
	public void setLastseen(Date lastseen) {
		this.lastseen = lastseen;
	}
    
}
