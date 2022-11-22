package com.kitady.gke.quarkus.common;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * ExceptionMapper
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {

  /** HTTP Headers */
  @Context
  private HttpHeaders headers;

  /** HttpRequests */
  @Context
  HttpServletRequest request;

  /**
   * Handles unexpected Excptions
   */
  @Override
  public Response toResponse(Throwable e) {

    Response res = null;
    ResponseBuilder rb = null;
    rb = Response.status(Status.INTERNAL_SERVER_ERROR);
    rb.type(headers.getMediaType()).entity("error occured: " + e.getMessage());
    res = rb.build();

    return res;
  }
}
