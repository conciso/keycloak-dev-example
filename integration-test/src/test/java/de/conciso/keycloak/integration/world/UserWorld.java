package de.conciso.keycloak.integration.world;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserWorld {

  private User currentUser;

  public void setCurrentUser(User currentUser) {
    this.currentUser = currentUser;
  }

  public User getCurrentUser() {
    return currentUser;
  }
}
