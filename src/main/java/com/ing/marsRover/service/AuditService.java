package com.ing.marsRover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.marsRover.dto.AuditNasaCalls;
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
  public void saveAuditInfo(AuditNasaCalls auditNasa) {
    
    auditRepository.save(auditNasa);
    
  }

}
