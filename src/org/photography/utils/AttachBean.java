package org.photography.utils;

import java.io.File;

/*
 * 闄勪欢绫伙紝鍙湁鏂囦欢锛屽嵆闄勪欢鎵嶆枃浠跺悕
 */
public class AttachBean {
	private String cid;
	private File file;
	private String fileName;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public AttachBean() {

	}

	public AttachBean(File file, String fileName) {
		super();
		this.file = file;
		this.fileName = fileName;
	}
}
