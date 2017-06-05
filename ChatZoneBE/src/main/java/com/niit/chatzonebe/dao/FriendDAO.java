package com.niit.chatzonebe.dao;

import java.util.List;

import com.niit.chatzonebe.model.Friend;

public interface FriendDAO {
	
	public List<Friend> list();
	
	public List<Friend> listFriendsByUserId(String id);
	
	public List<Friend> listFriendsByFriendId(String friendid);
	
	public Friend getFriendById(int fid);
	
	public boolean save(Friend friend);
	
	public boolean delete(Friend friend);
	
	
	
 
}
