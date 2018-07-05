package me.lgblog.util;

public class Result {
	private String result;
	private String message;
	
	public Result() {
	}
	
	public Result(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
