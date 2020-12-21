package com.src.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * The <code> CreatePayOutBeneficiary </code> class defines a POJO for creating
 * benificary details for pay out functionality.
 * 
 * @author azmiri.
 * @version 1.0
 * 
 */
public class CreatePayOutBeneficiary implements Serializable {

	private static final long serialVersionUID = -44196351047811690L;
 
	@JsonProperty("status")
	private String status;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("code")
	private String code;

	@JsonProperty("data")
	private JsonNode  data;

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
