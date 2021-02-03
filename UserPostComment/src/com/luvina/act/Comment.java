package com.luvina.act;

import com.luvina.user.User;

public class Comment {

	public long id;
	private String title;
	private Post post; // Bài viết mà comment gắn vào
	private User author; // Tác giả của comment
	
	public Comment(long id, String title, Post post, User author) {
		this.id = id;
		this.title = title;
		this.post = post;
		this.author = author;
	}
	
	
}
