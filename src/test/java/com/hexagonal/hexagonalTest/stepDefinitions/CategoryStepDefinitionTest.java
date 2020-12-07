package com.hexagonal.hexagonalTest.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.slf4j.Logger;

@RunWith(Cucumber.class)
public class CategoryStepDefinitionTest extends AbstractSpringConfigurationTest {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(CategoryStepDefinitionTest.class);

    private String name_en;
    private String name;
    private int parent;
    private String image;
    private Character kind;
    private int priority;
    private boolean visibility;

    private ResponseEntity<String> response = null;

    @Given("^create category with following detail$")
    public void create_category_with_following_detail(DataTable data) {
        //|phone  |phone |4      |image.png  |2    |2        |true       |
        List<List<String>> obj = data.raw();
        name_en = obj.get(0).get(0);
        name = obj.get(0).get(1);
        parent = Integer.parseInt(obj.get(0).get(2));
        image= obj.get(0).get(3);
        kind = obj.get(0).get(4).charAt(0);
        priority = Integer.parseInt(obj.get(0).get(5));
        visibility = Boolean.parseBoolean(obj.get(0).get(6));

//        if (logger.isInfoEnabled()) {
//            logger.info("Category to be saved with name {}", name);
//        }
    }

    @When("^the client calls \"([^\"]*)\" with the given detail$")
    public void the_client_calls_with_the_given_detail(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the client receive status code of (\\d+)$")
    public void the_client_receive_status_code_of(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the response contains name \"([^\"]*)\"$")
    public void the_response_contains_name(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^the client calls POST \"([^\"]*)\" with the given detail$")
    public void theClientCallsPOSTWithTheGivenDetail(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
