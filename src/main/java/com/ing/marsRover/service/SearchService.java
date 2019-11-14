package com.ing.marsRover.service;

import org.springframework.stereotype.Service;
import com.ing.marsRover.entities.AuditInfo;
import com.ing.marsRover.entities.SearchRequest;
import com.ing.marsRover.entities.SearchResponse;
import com.ing.marsRover.helper.NasaApi;
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
   * Method responsible of calling the helper class NasaApi that does the call to the NasaApi and
   * also connects to the AuditService in order to save the auditing information in our H2 DB.
   * 
   * @param request
   * @return SearchResponse
   */

  public SearchResponse retrieveMarsPhotos(SearchRequest request) {
    SearchResponse response = nasaApi.getPhotos(request);
    
    // Create audit info
    AuditInfo auditInfo = AuditInfo.builder().build();
    auditService.saveAuditInfo(auditInfo);

    return response;

  }

}