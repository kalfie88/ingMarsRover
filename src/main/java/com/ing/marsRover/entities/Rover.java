package com.ing.marsRover.entities;

import java.time.LocalDate;
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
public class Rover {
  
  private Long id;
  private String name;
  private LocalDate landingDate;
  private LocalDate launchDate;
  private String status;
  private Long maxSol;
  private LocalDate maxDate;
  private Long totalPhotos;
  private List<RoverCameras> roverCameras;

}

