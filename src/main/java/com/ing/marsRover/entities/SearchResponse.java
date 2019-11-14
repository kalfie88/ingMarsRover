package com.ing.marsRover.entities;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author kalfie
 *
 */

@Data
@Builder
public class SearchResponse {
  
  private String message;
  private List<NasaResponse> nasaResponse;

}
