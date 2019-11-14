package com.ing.marsRover.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author kalfie
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarsRoverResponseObject {

  private List<MarsRoverPhoto> photos;
  
}
