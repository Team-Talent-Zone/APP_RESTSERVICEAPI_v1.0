package com.src.entity;

import java.io.Serializable;

/**
 * The <code>PayoutToken </code> defines a class
 * to generate a unique token which
 * is used for Payout functionality.
 * 
 * @author azmiri
 * @version 1.0
 *
 */

public class PayoutToken implements Serializable {

	private static final long serialVersionUID = 8411482816741692633L;

	String access_token;
	String token_type;
	int expires_in;
	String refresh_token;
	String scope;
	int created_at;
	String user_uuid;

	public String getAccess_token() { 
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expire_in) {
		this.expires_in = expire_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getCreated_at() {
		return created_at;
	}

	public void setCreated_at(int created_at) {
		this.created_at = created_at;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

}
