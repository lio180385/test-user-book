package com.books.user.request;

import java.util.List;

import lombok.Data;
@Data
public class RequestUserAndBook {
	
	private long userId;
	private List<RequestBook> books;

}
