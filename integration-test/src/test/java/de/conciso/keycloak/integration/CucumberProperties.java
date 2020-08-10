package de.conciso.keycloak.integration;

public class CucumberProperties {

  public static String getServiceHost() {
    return System.getProperty("service.host", "localhost");
  }

  public static String getServiceHttpPort() {
    return System.getProperty("service.http.port", "8080");
  }

  public static String getBaseUri() {
    return String.format("http://%s:%s", getServiceHost(), getServiceHttpPort() + "/auth");
  }

}
