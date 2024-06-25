package org.acme;

import io.quarkus.oidc.client.filter.OidcClientRequestFilter;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "myclient")
@RegisterProvider(OidcClientRequestFilter.class)
@Path("/hello")
public interface JustClient {

  @GET
  String call();
}
