package com.luvina.user;

import java.util.ArrayList;

import com.luvina.act.Post;
import com.luvina.act.PostException;
import com.luvina.act.Comment;
import com.luvina.act.CommentEcxeption;

public class User {
	private long id;
	private String fullName;
	private ArrayList<Post> posts;
	private ArrayList<Comment> comments;

	void writePost(Post post) {
		System.out.println(id + "Post");
	}

	void deletePost(Post post) throws PostException {
		// logic delete post
	}

	void writeComment(Post post, Comment comment) {
		//gan comment vao bai post
		
	}

	void deleteComment(Post post, Comment comment) throws CommentEcxeption {
		//logic delete comment
	}
}
