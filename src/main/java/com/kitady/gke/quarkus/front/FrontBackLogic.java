package com.kitady.gke.quarkus.front;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@RequestScoped
public class FrontBackLogic {

  public String execute(String method, String hostname, String port) {

    try {
      Client client = ClientBuilder.newClient();
      Builder builder =
          client.target(method + "://" + hostname + ":" + port + "/hostinfo").request();
      builder.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
      Response response = builder.get();
      if (response.getStatus() == Status.OK.getStatusCode()) {
        return response.readEntity(String.class);
      } else {
        String errMsg = "Backend API returned: " + response.getStatus();
        // return errMsg;
        throw new WebApplicationException(errMsg, Response.Status.INTERNAL_SERVER_ERROR);
      }
    } catch (Exception e) {
      throw new WebApplicationException(e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
