package com.playtech.spliturl.statemachine;

import java.net.URL;

import com.playtech.spliturl.model.URLModel;

public enum URLState implements State {

	START {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			return SCHEME;
		}
	},
	SCHEME {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			urlModelBuilder.setScheme(url.getProtocol());
			return HOST;
		}
	},
	HOST {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			urlModelBuilder.setHost(url.getHost());
			return PORT;
		}
	},
	PORT {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			urlModelBuilder.setPort(url.getPort() == -1 ? null : new Integer(url.getPort()));
			return PATH;
		}
	},
	PATH {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			urlModelBuilder.setPath(url.getPath().length() > 1 ? url.getPath().substring(1) : null);
			return PARAMETERS;
		}
	},
	PARAMETERS {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			urlModelBuilder.setParameters(url.getQuery());
			return END;
		}
	},
	END {
		public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder) {
			return this;
		}
	};
}