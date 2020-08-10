package de.conciso.keycloak.integration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:specification"},
    glue = {"de.conciso.keycloak.integration"},
    snippets = CucumberOptions.SnippetType.CAMELCASE)
public final class CucumberIT {
}
