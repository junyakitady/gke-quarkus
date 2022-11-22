package com.kitady.gke.quarkus.common;

import java.util.HashMap;
import java.util.Map;

public class BaseResource {

  protected Map<String, String> gethostInfo() {
    final String hostname = System.getenv("HOSTNAME");
    final String servicename = System.getenv("K_SERVICE");
    final String revision = System.getenv("K_REVISION");
    final String port = System.getenv("PORT");

    final Map<String, String> map = new HashMap<>();
    map.put("hostname", hostname);
    map.put("run_servicename", servicename);
    map.put("run_revision", revision);
    map.put("port", port);
    return map;
  }

}
