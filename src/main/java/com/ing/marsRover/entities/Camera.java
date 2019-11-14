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
public class Camera {
  
  private Long id;
  private String name;
  private Long roverId;
  private String fullName;

}