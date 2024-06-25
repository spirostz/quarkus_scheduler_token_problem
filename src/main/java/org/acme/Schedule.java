package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class Schedule {

  @Inject @RestClient JustClient justClient;

  @Scheduled(cron = "${service.cron}")
  public void schedule() {
    Log.info("Calling client");
    String res = justClient.call();
    assert res.equals("Hello RESTEasy");
  }
}
