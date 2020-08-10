Ability: Check Configuration of Keycloak Docker Image

  Scenario Template: Check if user can login and gets access token
    Given I am the user <username> and my password is <password>
    When I try to log in to the client <clientId> with secret <clientSecret> on realm <realm>
    Then I get an access token

    Examples:
      | realm                 | clientId            | clientSecret                         | username | password |
      | test-realm            | test-client         | 78a10012-188a-45e7-9d58-cc557f237087 | test     | test     |
