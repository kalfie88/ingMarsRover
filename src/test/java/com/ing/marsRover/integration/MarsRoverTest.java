package com.ing.marsRover.integration;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.http.HttpHeaders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.gson.Gson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author kalfie
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 8089)
public class MarsRoverTest {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private ObjectMapper objectMapper;

  private MockMvc mvc;

  private String expectedJson;

  private Gson gson;


  @Before
  public void setup() throws Exception {
    WireMock.reset();

    mvc = MockMvcBuilders
        .webAppContextSetup(context)
        .build();

    this.gson = new Gson();

    Resource fixture = new ClassPathResource("sol_curiosity_fhaz.json");
    this.expectedJson =
        new String(Files.readAllBytes(Paths.get(fixture.getFile().getAbsolutePath())));

    stubFor(get(urlMatching("/mars-photos/api/v1/rovers/curiosity/photos"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
            .withBody(this.expectedJson)));
  }

  @Test
  public void retrievedMarsPhotos_valid() throws JsonProcessingException, Exception {
    String dateType = "sol";
    String dateValue = "1000";
    String camera = "fhaz";
    String name = "curiosity";

    MarsRoverRequest request = MarsRoverRequest.builder()
        .dateType(dateType)
        .dateValue(dateValue)
        .camera(camera)
        .name(name)
        .build();

    MarsRoverResponseObject expectedResponse =
        gson.fromJson(this.expectedJson, MarsRoverResponseObject.class);

    mvc.perform(MockMvcRequestBuilders.post("/mars-rover/v1/retrievePhotos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));

  }

}
