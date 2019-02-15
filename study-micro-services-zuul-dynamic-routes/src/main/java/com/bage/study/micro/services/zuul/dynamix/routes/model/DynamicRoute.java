package com.bage.study.micro.services.zuul.dynamix.routes.model;

import java.io.Serializable;

/**
 * Dynamic route request object saved in Redis
 * @author vikasanand
 *
 */
public class DynamicRoute  implements Serializable {

	private static final long serialVersionUID = -6719150427066586659L;

	/**
	 * This can be a unique key different for each route registration. It should be different 
	 * for each requestURI to be forwarded.
	 * i.e. asad121-sadas-hjjhhd
	 */
	public String requestURIUniqueKey;
	
	/**
	 * This can be of format "/api1"
	 * It should be sub-path URI which needs to forwarded to different proxy
	 */
	private String requestURI;
	
	/**
	 * Target Host name or IP
	 * i.e. https://adomain.com
	 */
	private String targetURLHost;

	/**
	 * Target Port to forward
	 * i.e. 80
	 */
	private int targetURLPort;
	
	/**
	 * Target URI to forward
	 * /proxy-api1
	 */
	private String targetURIPath;

	public String getRequestURIUniqueKey() {
		return requestURIUniqueKey;
	}

	public void setRequestURIUniqueKey(String requestURIUniqueKey) {
		this.requestURIUniqueKey = requestURIUniqueKey;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getTargetURLHost() {
		return targetURLHost;
	}

	public void setTargetURLHost(String targetURLHost) {
		this.targetURLHost = targetURLHost;
	}

	public int getTargetURLPort() {
		return targetURLPort;
	}

	public void setTargetURLPort(int targetURLPort) {
		this.targetURLPort = targetURLPort;
	}

	public String getTargetURIPath() {
		return targetURIPath;
	}

	public void setTargetURIPath(String targetURIPath) {
		this.targetURIPath = targetURIPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestURIUniqueKey == null) ? 0 : requestURIUniqueKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DynamicRoute other = (DynamicRoute) obj;
		if (requestURIUniqueKey == null) {
			if (other.requestURIUniqueKey != null)
				return false;
		} else if (!requestURIUniqueKey.equals(other.requestURIUniqueKey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DynamicRoute [requestURIUniqueKey=");
		builder.append(requestURIUniqueKey);
		builder.append(", requestURI=");
		builder.append(requestURI);
		builder.append(", targetURLHost=");
		builder.append(targetURLHost);
		builder.append(", targetURLPort=");
		builder.append(targetURLPort);
		builder.append(", targetURIPath=");
		builder.append(targetURIPath);
		builder.append("]");
		return builder.toString();
	}

}
