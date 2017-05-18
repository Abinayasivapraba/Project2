package com.niit.chatzonebe.model;

import javax.persistence.Transient;

public class BaseDomain {
	private String errormessage;
	private String errorcode;
	@Transient
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	@Transient
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

}
