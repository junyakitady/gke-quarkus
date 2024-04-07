package com.kitady.gke.quarkus.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

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
