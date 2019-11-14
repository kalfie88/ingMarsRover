package com.ing.marsRover.helper;

import java.io.IOException;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.marsRover.entities.SearchRequest;
import com.ing.marsRover.entities.SearchResponse;
import com.ing.marsRover.entities.NasaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static java.util.Arrays.asList;

/**
 * @author kalfie
 *
 */

@Slf4j
@RequiredArgsConstructor
public class NasaApi {

  @Value("${nasaApi.url}")
  private final String nasaApiUrl;
  private final ObjectMapper objectMapper;
  private final RestTemplate template;


  /**
   * This method will call the external NasaApi GET endpoint and it will map the response to our
   * entity
   * 
   * @param request
   * @return SearchResponse
   */
  public SearchResponse getPhotos(SearchRequest request) {

    URI uri = UriComponentsBuilder.fromUriString(nasaApiUrl)
        // .queryParam(name, values)
        .build().toUri();

    try {
      log.debug("Calling NASA API with request: " + request);

      ResponseEntity<String> response = template.getForEntity(uri, String.class);

      if (response == null) {
        return null;

      } else {
        String bodyAsString = response.getBody();

        if (response.getStatusCode() == HttpStatus.OK && !bodyAsString.contains("Error")) {
          return SearchResponse.builder()
              .nasaResponse(asList(objectMapper.readValue(bodyAsString, NasaResponse.class)))
              .build();

        }

      }

      if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
        return SearchResponse.builder().message("Not Found").build();
      }

      log.error("unknown response {} from NASA Api, status code {}", response,
          response.getStatusCode() == null ? "none" : response.getStatusCode());

    } catch (IOException e) {
      log.error("Error occurred while reading JSON", e);

    } catch (Exception e) {
      log.error("Error occurred while retrieving NASA Rover photos", e);

    }

    return null;

  }

}
