package com.src.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class PayoutVerifyAccountResponseData implements Serializable {

	private static final long serialVersionUID = 8480275827741452611L;
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("msg")
	private String msg;
	@JsonProperty("code")
	private String code;

	@JsonProperty("data")
	private JsonNode  data;

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

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	} 
	
	
	


}
