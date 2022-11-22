package com.kitady.gke.quarkus.front;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
