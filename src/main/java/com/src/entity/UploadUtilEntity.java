package com.src.entity;

import java.io.Serializable;

/**
 * The <code> UploadUtilEntity </code> class defines managed beans which
 * provides functionality on the <code>Upload Util Entity</code> Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class UploadUtilEntity implements Serializable {
	private String base64image;
	private int userid;
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getBase64image() {
		return base64image;
	}

	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
