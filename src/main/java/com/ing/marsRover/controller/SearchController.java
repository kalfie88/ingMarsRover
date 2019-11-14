package com.ing.marsRover.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.marsRover.entities.SearchRequest;
import com.ing.marsRover.entities.NasaResponse;
import com.ing.marsRover.service.SearchService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mars-rover/v1")
@RequiredArgsConstructor
public class SearchController {

  private final SearchService searchService;


  @PostMapping(value = "/retrievePhotos")
  public ResponseEntity<List<NasaResponse>> retrieveMarsPhotos(@RequestBody SearchRequest request) {
    searchService.retrieveMarsPhotos(request);
    
    return null;
  }

}
