package com.kitady.gke.quarkus.common;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * REST I/F Access Log
 */
public class AccessLoggingFilter implements Filter {

  private static final String LOG_SEPARATOR = " ";

  public AccessLoggingFilter() {}

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

  public void destroy() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    LocalDateTime requestTime = LocalDateTime.now();

    HttpServletRequest req = (HttpServletRequest) request;

    String uri = req.getRequestURI();
    String method = req.getMethod();

    try {
      chain.doFilter(request, response);
    } finally {
      HttpServletResponse res = (HttpServletResponse) response;

      LocalDateTime responseTime = LocalDateTime.now();
      System.out.println(new StringBuilder("[KTD] ").append(Integer.toString(res.getStatus()))
          .append(LOG_SEPARATOR).append(method).append(LOG_SEPARATOR).append(uri)
          .append(LOG_SEPARATOR).append(Duration.between(requestTime, responseTime).toString())
          .toString());
    }
  }
}
