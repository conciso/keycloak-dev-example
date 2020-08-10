package de.conciso.keycloak.integration.world;

import java.util.Optional;
import java.util.Stack;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenWorld {

  private Stack<String> accessTokens = new Stack<>();

  public void setCurrentAccessToken(String currentAccessToken) {
    this.accessTokens.push(currentAccessToken);
  }

  public Optional<String> getCurrentAccessToken() {
    return Optional.ofNullable(accessTokens.peek());
  }
}
