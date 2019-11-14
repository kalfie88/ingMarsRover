package com.ing.marsRover.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kalfie
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarsRoverRequest {
  
  private String name;
  private String dateType;
  private String dateValue;
  private String camera;

}
