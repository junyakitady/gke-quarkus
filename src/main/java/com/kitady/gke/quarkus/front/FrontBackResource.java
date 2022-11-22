package com.kitady.gke.quarkus.front;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
