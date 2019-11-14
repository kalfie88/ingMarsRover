package com.ing.marsRover.service;

import org.springframework.stereotype.Service;
import com.ing.marsRover.entities.AuditInfo;
import com.ing.marsRover.entities.SearchRequest;
import com.ing.marsRover.entities.SearchResponse;
import com.ing.marsRover.utils.NasaApi;
import lombok.RequiredArgsConstructor;

/**
 * @author kalfie
 *
 */

@Service
@RequiredArgsConstructor
public class SearchService {
  
  private NasaApi nasaApi;
  private AuditService auditService;

  /**
   * @param request
   */
  public SearchResponse retrieveMarsPhotos(SearchRequest request) {
    SearchResponse response = nasaApi.getPhotos(request);
    //Create audit info
    AuditInfo auditInfo = AuditInfo.builder().build();
    auditService.saveAuditInfo(auditInfo);
    
    return response;
    
  }

}
