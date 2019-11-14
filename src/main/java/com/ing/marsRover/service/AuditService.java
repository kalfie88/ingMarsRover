package com.ing.marsRover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.marsRover.dto.AuditNasaCalls;
import com.ing.marsRover.entities.AuditInfo;
import com.ing.marsRover.repository.AuditRepository;

/**
 * @author kalfie
 *
 */
@Service
public class AuditService {
  
  @Autowired
  private AuditRepository auditRepository;
  
  /**
   * Connects with the AuditRepository to save the audit information
   * @param auditInfo
   */
  public void saveAuditInfo(AuditInfo auditInfo) {
    AuditNasaCalls auditNasa = AuditNasaCalls.builder()
        .requestMethodName(auditInfo.getRequestMethodName())
        .responseTime(auditInfo.getResponseTime())
        .createdDate(auditInfo.getCreatedDate())
        .build();
    
    auditRepository.save(auditNasa);
    
  }

}
