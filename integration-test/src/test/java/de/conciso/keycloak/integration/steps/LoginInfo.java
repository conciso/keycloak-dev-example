package de.conciso.keycloak.integration.steps;

import de.conciso.keycloak.integration.world.User;

final class LoginInfo {

  private final User user;
  private final String realm;
  private final String clientId;
  private final String clientSecret;
  private final GrantType grantType;

  LoginInfo(User user, String realm, String clientId, String clientSecret) {
    this.user = user;
    this.realm = realm;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.grantType = GrantType.PASSWORD;
  }

  LoginInfo(String realm, String clientId, String clientSecret) {
    this.user = null;
    this.realm = realm;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.grantType = GrantType.CLIENT_CREDENTIALS;
  }

  String getClientId() {
    return clientId;
  }

  String getClientSecret() {
    return clientSecret;
  }

  String getRealm() {
    return realm;
  }

  String getPassword() {
    return user != null ? user.getPassword() : null;
  }

  String getUsername() {
    return user != null ? user.getUsername() : null;
  }

  GrantType getGrantType() {
    return grantType;
  }
}
