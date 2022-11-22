package com.kitady.gke.quarkus.back;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
