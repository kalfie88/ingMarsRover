package com.ing.marsRover.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * @author kalfie
 *
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarsRoverResponseObject {

  private List<MarsRoverPhoto> photos;
  
}
