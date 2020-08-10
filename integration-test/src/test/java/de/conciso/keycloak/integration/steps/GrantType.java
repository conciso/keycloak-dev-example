package de.conciso.keycloak.integration.steps;

public enum GrantType {
  PASSWORD("password"),
  CLIENT_CREDENTIALS("client_credentials");

  private String value;

  GrantType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
