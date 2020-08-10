package de.conciso.keycloak.integration.steps;

import de.conciso.keycloak.integration.CucumberProperties;
import de.conciso.keycloak.integration.world.TokenWorld;
import de.conciso.keycloak.integration.world.UserWorld;

import io.cucumber.java.en.When;
import javax.inject.Inject;

public class LoginStepDefs {

  @Inject
  UserWorld userWorld;

  @Inject
  TokenWorld tokenWorld;

  @When("^I try to log in to the client (.+) with secret (.+) on realm (.+)$")
  public void whenITryToLogIn(String clientId, String clientSecret, String realm) {
    AccessTokenSupplier accessTokenSupplier = new AccessTokenSupplier(CucumberProperties.getBaseUri(),
        new LoginInfo(userWorld.getCurrentUser(), realm, clientId, clientSecret));
    tokenWorld.setCurrentAccessToken(accessTokenSupplier.get());
  }

  @When("^I request a token from (.+) with secret (.+) on realm (.+)$")
  public void whenIRequestATokenAsAClient(String clientId, String clientSecret, String realm) {
    AccessTokenSupplier accessTokenSupplier = new AccessTokenSupplier(CucumberProperties.getBaseUri(),
            new LoginInfo(realm, clientId, clientSecret));
    tokenWorld.setCurrentAccessToken(accessTokenSupplier.get());
  }
}
