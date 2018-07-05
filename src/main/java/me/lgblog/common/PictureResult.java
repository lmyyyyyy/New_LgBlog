package me.lgblog.common;

public class PictureResult {
	private int errno;
	private String[] data;
	
	public PictureResult(String[] data,int errno) {
		super();
		this.errno = errno;
		this.data = data;
	}

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	
}
