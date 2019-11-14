package com.ing.marsRover.entities;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
/**
 * @author kalfie
 *
 */

@Data
@Builder
public class AuditInfo {
  
  private String id;
  private String requestMethodName;
  private Long responseTime;
  private LocalDateTime createdDate;

}
