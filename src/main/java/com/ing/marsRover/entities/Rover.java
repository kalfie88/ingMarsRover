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
public class Rover {
  
  private int id;
  private int max_sol;
  private int total_photos;
  private String name;
  private String landing_date;
  private String launch_date;
  private String max_date;
  private String status;
  private List<Camera> cameras;
}
