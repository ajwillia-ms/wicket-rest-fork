package org.innobuilt.wicket.rest.jsonrpc;

import java.io.Serializable;

public class Response implements Serializable{
	private Object result;
	private String id;
	private String jsonrpc;
	private org.innobuilt.wicket.rest.jsonrpc.Error error;
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}
	public String getJsonrpc() {
		return jsonrpc;
	}
	public void setError(org.innobuilt.wicket.rest.jsonrpc.Error error) {
		this.error = error;
	}
	public org.innobuilt.wicket.rest.jsonrpc.Error getError() {
		return error;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Object getResult() {
		return result;
	}
}
