package com.playtech.spliturl.model;

public class URLModel {

	private String scheme;
	private String host;
	private Integer port;
	private String path;
	private String parameters;

	public URLModel(URLModelBuilder urlModelBuilder) {
		super();
		this.scheme = urlModelBuilder.scheme;
		this.host = urlModelBuilder.host;
		this.port = urlModelBuilder.port;
		this.path = urlModelBuilder.path;
		this.parameters = urlModelBuilder.parameters;
	}

	public static URLModelBuilder builder() {
		return new URLModelBuilder();
	}

	// Builder Class
	public static class URLModelBuilder {

		private String scheme;
		private String host;
		private Integer port;
		private String path;
		private String parameters;

		public URLModelBuilder setScheme(String scheme) {
			this.scheme = scheme;
			return this;
		}

		public URLModelBuilder setHost(String host) {
			this.host = host;
			return this;
		}

		public URLModelBuilder setPort(Integer port) {
			this.port = port;
			return this;
		}

		public URLModelBuilder setPath(String path) {
			this.path = path;
			return this;
		}

		public URLModelBuilder setParameters(String parameters) {
			this.parameters = parameters;
			return this;
		}

		public URLModel build() {
			return new URLModel(this);
		}

	}

	public String getScheme() {
		return scheme;
	}

	public String getHost() {
		return host;
	}

	public Integer getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public String getParameters() {
		return parameters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((scheme == null) ? 0 : scheme.hashCode());
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
		URLModel other = (URLModel) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (scheme == null) {
			if (other.scheme != null)
				return false;
		} else if (!scheme.equals(other.scheme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return scheme + "\n" + host + "\n" + port + "\n" + path + "\n" + parameters;
	}

}
