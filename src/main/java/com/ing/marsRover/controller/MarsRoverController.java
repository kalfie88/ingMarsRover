package com.ing.marsRover.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.service.MarsRoverService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mars-rover/v1")
@RequiredArgsConstructor
public class MarsRoverController {

  private final MarsRoverService searchService;

  /**
   * 
   * @param request
   * @return ResponseEntity<?> that can be a BadRequest or the OK with SearchResponse body
   */

  @PostMapping(value = "/retrievePhotos")
  public ResponseEntity<?> retrieveMarsPhotos(@RequestBody MarsRoverRequest request) {
    if (request == null) {
      return ResponseEntity.badRequest().build();

    }
    
    return ResponseEntity.ok().body(searchService.retrieveMarsPhotos(request));
    
  }

}
