package org.innobuilt.wicket.rest.jsonrpc;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Request implements Serializable{
	private static final long serialVersionUID = 1;
	private String method;
	private String id;
	private Object[] params;
	private String jsonrpc;
	private Error error;
	private Method methodObject;

	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}
	public void setMethodObject(Method methodObject) {
		this.methodObject = methodObject;
	}
	public Method getMethodObject() {
		return methodObject;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public Error getError() {
		return error;
	}
	
}
