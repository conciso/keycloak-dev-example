package de.conciso.keycloak.integration.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import de.conciso.keycloak.integration.world.TokenWorld;

import io.cucumber.java.en.Then;
import javax.inject.Inject;

public class TokenStepdDefs {

  @Inject
  TokenWorld tokenWorld;

  @Then("^I get an access token$")
  public void thenIGetAnAccessToken() throws Throwable {
    assertThat(tokenWorld.getCurrentAccessToken().isPresent(), is(true));
  }
}
