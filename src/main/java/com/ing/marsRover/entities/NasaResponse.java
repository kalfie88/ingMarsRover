package com.ing.marsRover.entities;

import java.time.LocalDate;
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
public class NasaResponse {
 
  private Long id;
  private Long sol;
  private Camera camera;
  private String img_src;
  private LocalDate earthDate;
  private Rover rover;

}