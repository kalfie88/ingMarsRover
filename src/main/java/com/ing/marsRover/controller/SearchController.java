package com.ing.marsRover.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.marsRover.entities.SearchRequest;
import com.ing.marsRover.entities.SearchResponse;
import com.ing.marsRover.service.SearchService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mars-rover/v1")
@RequiredArgsConstructor
public class SearchController {

  private final SearchService searchService;

  /**
   * 
   * @param request
   * @return ResponseEntity<?> that can be a BadRequest or the OK with SearchResponse body
   */

  @PostMapping(value = "/retrievePhotos")
  public ResponseEntity<?> retrieveMarsPhotos(@RequestBody SearchRequest request) {
    if (request == null) {
      return ResponseEntity.badRequest().build();

    }

    SearchResponse response = searchService.retrieveMarsPhotos(request);
    return ResponseEntity.ok().body(response);
    
  }

}
