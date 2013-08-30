package com.axemblr.dropwizard.swagger;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.jaxrs.JaxrsApiReader;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Environment;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public class SwaggerBundle extends AssetsBundle {

	public static final String DEFAULT_PATH = "/swagger-ui";

	public SwaggerBundle() {
		this(DEFAULT_PATH);
	}

	public SwaggerBundle(String uriPath) {
		super(DEFAULT_PATH, uriPath, "index.html");
	}


	@Path("/api-docs")
	@Api("/api-docs")
	@Produces({"application/json"})
	class ApiListingResourceJSONWithoutSuffix extends ApiListingResourceJSON {
		public ApiListingResourceJSONWithoutSuffix() {
			JaxrsApiReader.setFormatString("");
		}
	}

	@Override
	public void run(Environment environment) {
		super.run(environment);
		environment.addResource(new ApiListingResourceJSONWithoutSuffix());
	}
}
