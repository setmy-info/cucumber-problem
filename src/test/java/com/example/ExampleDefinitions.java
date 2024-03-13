package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleDefinitions {

    private String text;
    private int hashCode;

    @Given("text is {string}")
    public void textIs(final String input) {
        text = input;
    }

    @When("it is hashed")
    public void itIsHashed() {
        hashCode = text.hashCode();
    }

    @Then("hash should be {int}")
    public void the_hash_should_be(final int expectedHash) {
        assertThat(hashCode).isEqualTo(expectedHash);
    }
}
