package com.ing.marsRover.helper;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.Gson;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import com.ing.marsRover.enums.SearchCriteriaEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author kalfie
 *
 */

@Service
@Slf4j
public class NasaApi {


  private final String nasaApiUrl;
  private final String nasaApiKey;
  private final RestTemplate template;
  private final Gson gson;

  @Autowired
  public NasaApi(@Value("${nasaApi.url}") String nasaApiUrl,
      @Value("${nasaApi.key}") String nasaApiKey, RestTemplateBuilder templateBuilder, Gson gson) {
    this.nasaApiUrl = nasaApiUrl;
    this.nasaApiKey = nasaApiKey;
    this.template = templateBuilder.build();
    this.gson = gson;

  }


  /**
   * This method will call the external NasaApi GET endpoint and it will map the response to our
   * entity
   * 
   * @param request
   * @return SearchResponse
   */
  public MarsRoverResponseObject getPhotos(MarsRoverRequest request) {

    try {
      URI uri = buildUri(request);
      log.debug(Constants.BEFORE_CALL + request);

      ResponseEntity<String> response = template.getForEntity(uri, String.class);

      if (response == null) {
        return null;

      } else {

        String bodyAsString = response.getBody();

        if (response.getStatusCode() == HttpStatus.OK && !bodyAsString.contains(Constants.ERROR)) {

          log.debug(Constants.AFTER_CALL + response);
          return gson.fromJson(bodyAsString, MarsRoverResponseObject.class);
        }

      }

    } catch (Exception e) {
      log.error(Constants.EXCEPTION_ERROR, e);

    }

    return null;

  }


  /**
   * Helper method to validate the parameters in the request and build the URI
   * 
   * @param request
   * @return URI
   */
  private URI buildUri(MarsRoverRequest request) {
    MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();

    if (!request.getDateType().isEmpty() && !request.getDateValue().isEmpty()) {
      queryMap.add(request.getDateType(), request.getDateValue());
    }

    Optional.ofNullable(request.getName())
        .ifPresent(a -> queryMap.add(SearchCriteriaEnum.NAME.getCriteria(), request.getName()));
    Optional.ofNullable(request.getCamera())
        .ifPresent(a -> queryMap.add(SearchCriteriaEnum.CAMERA.getCriteria(), request.getCamera()));
    Optional.ofNullable(nasaApiKey)
        .ifPresent(a -> queryMap.add(SearchCriteriaEnum.API_KEY.getCriteria(), nasaApiKey));


    return UriComponentsBuilder.fromUriString(nasaApiUrl).queryParams(queryMap).build().toUri();

  }

}
