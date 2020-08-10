package de.conciso.keycloak.integration.steps;

import static io.restassured.RestAssured.given;

import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

final class AccessTokenSupplier implements Supplier<String> {

  private final LoginInfo loginInfo;
  private final String baseUri;

  AccessTokenSupplier(final String baseUri, LoginInfo loginInfo) {
    this.baseUri = baseUri;
    this.loginInfo = loginInfo;
  }

  @Override
  public String get() {
    Map<String, String> params = new HashMap<>();
    params.put("grant_type", loginInfo.getGrantType().getValue());
    params.put("client_id", loginInfo.getClientId());
    params.put("client_secret", loginInfo.getClientSecret());
    if (loginInfo.getGrantType() == GrantType.PASSWORD) {
      params.put("username", loginInfo.getUsername());
      params.put("password", loginInfo.getPassword());
    }

    String tokenResponse = given()
        .baseUri(baseUri)
        .params(params)
        .log().ifValidationFails(LogDetail.ALL, true)
        .when()
        .post("/realms/" + loginInfo.getRealm() + "/protocol/openid-connect/token")
        .then().statusCode(200)
        .extract().response().asString();
    JsonPath jsonPath = new JsonPath(tokenResponse);
    return jsonPath.getString("access_token");
  }
}
