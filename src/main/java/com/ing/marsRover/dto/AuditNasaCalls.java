package com.ing.marsRover.dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Builder;
import lombok.Data;

/**
 * @author kalfie
 *
 */

@Entity
@Data
@Builder
@Table(name = "audit_nasa_calls")
@EntityListeners({AuditingEntityListener.class})
public class AuditNasaCalls {
 
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private String id;
  
  private String requestMethodName;
  private Long responseTime;
  
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime createdDate;

}
