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
public class MarsRoverPhoto {

  private int id;
  private int sol;
  private Camera camera;
  private String img_src;
  private String earth_date;
  private Rover rover;

}
