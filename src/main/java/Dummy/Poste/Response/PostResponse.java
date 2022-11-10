package model.Post.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse{

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	public int getUserId(){
		return userId;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}
}