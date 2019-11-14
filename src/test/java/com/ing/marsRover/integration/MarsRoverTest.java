package com.ing.marsRover.integration;

import java.nio.charset.StandardCharsets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.WebApplicationContext;
import com.ing.marsRover.controller.MarsRoverController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;

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

  
  @Before
  public void setup() throws Exception {
    WireMock.reset();

    mvc = MockMvcBuilders.webAppContextSetup(context).build();

    String fullJson = StreamUtils.copyToString(
        MarsRoverController.class.getResourceAsStream("fixtures/sol_curiosity_fhaz.json"),
        StandardCharsets.UTF_8);
  }
  
  @Test
  public void retrievedMarsPhotos_valid() {
    
    
  }

}
