package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class GreetingResourceTest {

  @Inject @RestClient JustClient justClient;

  // Demonstrates calls to token-protected endpoint without scheduler (never fails)
  //
  // To Demonstrate the scheduler approach, just START the application and wait for the logs (fails
  // after 10 minutes)
  @Test
  void callClient() throws InterruptedException {

    while (true) {
      String res = justClient.call();
      assertEquals("Hello RESTEasy", res);
      Thread.sleep(30_000);
      Log.info("Retrying");
    }
  }
}
