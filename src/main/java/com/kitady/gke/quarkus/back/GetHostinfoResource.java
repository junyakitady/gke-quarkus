package com.kitady.gke.quarkus.back;

import java.util.Map;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.kitady.gke.quarkus.common.BaseResource;

/**
 * GET host info
 */
@RequestScoped
@Path("/hostinfo")
public class GetHostinfoResource extends BaseResource {

  @GET
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Response execute() {

    final Map<String, String> map = gethostInfo();

    Response response = Response.ok(map).build();
    return response;
  }
}
