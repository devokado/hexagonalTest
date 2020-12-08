package com.hexagonal.hexagonalTest.stepDefinitions;


import static org.junit.Assert.assertEquals;

import cucumber.api.DataTable;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(Cucumber.class)
public class CategoryStepDefinitionTest extends AbstractSpringConfigurationTest {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(CategoryStepDefinitionTest.class);
    private ResponseEntity<String> response = null;
    private List<Map<String, String>> obj;

    private static String id;
    @Given("^create \"([^\"]*)\" with following detail$")
    public void create_with_following_detail(String arg1, DataTable table) throws Throwable {

        obj = table.asMaps(String.class, String.class);

        if (logger.isInfoEnabled()) {
            logger.info("{} to be saved with {}",arg1,obj);
        }
    }

    @Then("^the client receive status code of (\\d+)$")
    public void the_client_receive_status_code_of(int statusCode) throws Throwable {

        if (response!= null && response.getStatusCode().is2xxSuccessful())
        {
            assertEquals(statusCode, response.getStatusCode().value()) ;

        }
    }
    @Then("^the response has the following attribute$")
    public void the_response_has_the_following_attribute(DataTable table) throws Throwable {
        List<Map<String, String>> attr =  table.asMaps(String.class, String.class);
        if(response != null && response.getStatusCode().is2xxSuccessful()){
            String responseBody = response.getBody();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);
            for(int i=0; i<attr.size(); i++) {
                assertEquals(this.obj.get(i).get("value"), responseMap.get(this.obj.get(i).get("attribute")));
            }

        }
    }

    @When("^the client calls POST \"([^\"]*)\" with the given detail$")
    public void theClientCallsPOSTWithTheGivenDetail(String path) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("path {}", path);
        }
        String url = buildUrl(HOST, PORT, path);
        Map<String, Object> requestMap = new HashMap<>();

        for(int i=0; i<obj.size(); i++) {
            requestMap.put(this.obj.get(i).get("attribute"), this.obj.get(i).get("value"));
        }
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
        String responseBody = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);
        id =  String.valueOf(responseMap.get("id"));
    }

    @When("^the client calls GET \"([^\"]*)\" with id$")
    public void the_client_calls_GET_with_category_id(String path) throws Throwable {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(id));///
        String url = buildUrl(HOST, PORT, path, uriVariables);
        logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.GET, null);
    }
    @When("^the client calls DELETE \"([^\"]*)\" with id$")
    public void the_client_calls_DELETE_with_category_id(String path) throws Throwable {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",String.valueOf(id));
        String url = buildUrl(HOST, PORT, path, uriVariables);
        logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.DELETE, null);
    }
    @When("^the client calls PUT \"([^\"]*)\" with id and following detail$")
    public void the_client_calls_PUT_with_category_id_and_following_detail(String path, DataTable table) throws Throwable {
        obj = table.asMaps(String.class, String.class);
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(id));

        for(int i=0; i<obj.size(); i++) {
            uriVariables.put(this.obj.get(i).get("attribute"), this.obj.get(i).get("value"));
        }
        String url = buildUrl(HOST, PORT, path, uriVariables);
        HttpEntity<?> requestEntity = new HttpEntity<>(uriVariables, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.PUT, requestEntity);

    }



}