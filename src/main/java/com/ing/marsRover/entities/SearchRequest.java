package com.ing.marsRover.entities;

import lombok.Builder;
import lombok.Data;

/**
 * @author kalfie
 *
 */

@Data
@Builder
public class SearchRequest {
  
  private String roverType;
  private String dateType;
  private String camaraType;

}
