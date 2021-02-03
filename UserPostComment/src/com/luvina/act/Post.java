package com.luvina.act;

import java.util.ArrayList;

import com.luvina.user.User;

public class Post {
	private long id;
	private String title;
	private String content;
	private User author; // Tác giả của bài viết
	private ArrayList<Comment> comments; // Một post chứa nhiều Comment

	public Post(long id, String title, String content, User author, ArrayList<Comment> comments) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.comments = comments;

	}

	public Boolean addComment(Comment comment) {
		// xử lý logic add comment và return true khi add được, false khi không add được

		return true;
	}

	public Boolean deleteComment(Comment comment) {
		// logic cần xử lý check id author của comment có đúng là của user đang thực
		// hiện xóa hay không
		return id == comment.id;

	}
}
