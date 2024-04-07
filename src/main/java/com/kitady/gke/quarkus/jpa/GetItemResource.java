package com.kitady.gke.quarkus.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.kitady.gke.quarkus.common.BaseResource;

/**
 * GET data from Spanner
 */
@RequestScoped
@Path("/item")
public class GetItemResource extends BaseResource {

  @Inject
  protected ItemDao dao;

  @GET
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Response getItemList() {

    // call Spanner
    final List<Item> items = dao.getItemList(null);

    final Map<String, Object> map = new HashMap<>();
    map.put("hostinfo", gethostInfo());
    map.put("query", items);

    final Response response = Response.ok(map).build();
    return response;
  }

  @GET
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  @Path("/{uuid}")
  public Response getItem(@PathParam("uuid") final String uuid) {

    // call Spanner
    final List<Item> items = dao.getItemList(uuid);

    final Map<String, Object> map = new HashMap<>();
    map.put("hostinfo", gethostInfo());
    if (items.size() == 1) {
      map.put("query", items.get(0));
    } else {
      map.put("query", items);
    }

    final Response response = Response.ok(map).build();
    return response;
  }
}
