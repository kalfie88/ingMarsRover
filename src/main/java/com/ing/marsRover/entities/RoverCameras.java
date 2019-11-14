package com.ing.marsRover.entities;

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
public class RoverCameras {
  
  private String name;
  private String fullName;

}