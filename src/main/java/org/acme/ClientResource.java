package org.acme;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/client")
public class ClientResource {

  @Inject @RestClient JustClient justClient;

  @GET
  @Authenticated
  public String helloClient() {
    return justClient.call() + " CLIENT";
  }
}
