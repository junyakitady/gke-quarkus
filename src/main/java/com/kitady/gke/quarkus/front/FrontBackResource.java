package com.kitady.gke.quarkus.front;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.kitady.gke.quarkus.common.BaseResource;

/**
 * GET HOSTNAME of frontend and backend
 */
@RequestScoped
@Path("/front-back/{hostname}")
public class FrontBackResource extends BaseResource {

  @Inject
  protected FrontBackLogic logic;

  @GET
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Response execute(@PathParam("hostname") final String hostname) {
    final String method = System.getenv("METHOD") != null ? System.getenv("METHOD") : "http";
    final String port = System.getenv("PORT") != null ? System.getenv("PORT") : "9080";

    // call backend API
    final String backendResult = logic.execute(method, hostname, port);

    JsonObject back = Json.createReader(new StringReader(backendResult)).readObject();
    final Map<String, Object> map = new HashMap<>();
    map.put("frontend", gethostInfo());
    map.put("backend", back);

    final Response response = Response.ok(map).build();
    return response;
  }

}
