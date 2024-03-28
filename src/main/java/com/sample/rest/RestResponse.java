package com.sample.rest;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class RestResponse<T> {
	
	private HttpStatus status;	// 상태
	private String message;		// 메시지
	private List<T> items;		// 데이터
	
	private RestResponse(HttpStatus status, String message, List<T> items) {
		this.status = status;
		this.message = message;
		this.items = items;
	}
	
	public String getMessage() {
		return message;
	}
	public List<T> getItems() {
		return items;
	}
	public int getStatus() {
		return status.value();
	}
	
	public static <T> RestResponse<T> getResponse(HttpStatus status, String message, List<T> items){
		return new RestResponse<T>(status, message, items);
	}
	
	// 메소드 제네릭은
	public static <T> RestResponse<T> getResponse(List<T> items){
		return getResponse(HttpStatus.OK, HttpStatus.OK.toString(), items);
	}
	
	public static <T> RestResponse<T> getResponse(T item){
		return getResponse(HttpStatus.OK, HttpStatus.OK.toString(), List.of(item));
	}
	
	public static RestResponse<Void> getResponse(String message){
		return getResponse(HttpStatus.OK, message, List.of());
	}
	
	public static RestResponse<Void> getErrorResponse(HttpStatus status, String message){
		return getResponse(status, message, List.of());
	}
}
