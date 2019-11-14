package com.ing.marsRover.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author kalfie
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarsRoverPhoto {

  private int id;
  private int sol;
  private Camera camera;
  private String img_src;
  private String earth_date;
  private Rover rover;

}
