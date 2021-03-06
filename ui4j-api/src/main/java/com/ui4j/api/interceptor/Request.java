package com.ui4j.api.interceptor;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {

	private String url;

	private Map<String, String> headers = new HashMap<>();

	public Request(String url) {
		this.url = url;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getUrl() {
		return url;
	}

	public Request setHeader(String name, String value) {
		headers.put(name, value);
		return this;
	}

	public Request setCookies(List<HttpCookie> cookies) {
		StringBuilder builder = new StringBuilder();
		for (HttpCookie cookie : cookies) {
			builder
				.append(cookie.getName())
				.append("=")
				.append(cookie.getValue())
				.append(";");
		}
		setHeader("Cookie", builder.toString());
		return this;
	}

	@Override
	public String toString() {
		return "Request [url=" + url + ", headers=" + headers + "]";
	}
}
