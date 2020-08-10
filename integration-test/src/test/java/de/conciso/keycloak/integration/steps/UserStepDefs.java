package de.conciso.keycloak.integration.steps;

import de.conciso.keycloak.integration.world.User;
import de.conciso.keycloak.integration.world.UserWorld;

import io.cucumber.java.en.Given;
import javax.inject.Inject;

public class UserStepDefs {

  @Inject
  UserWorld userWorld;

  @Given("^I am the user (.+) and my password is (.+)$")
  public void givenIAmTheUserUsernameAndMyPasswordIsPassword(String username, String password) {
    User user = new User(username, password);
    userWorld.setCurrentUser(user);
  }
}
