package com.ing.marsRover.service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import com.google.common.base.Stopwatch;
import com.ing.marsRover.dto.AuditNasaCalls;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.helper.NasaApi;
import lombok.RequiredArgsConstructor;
import com.ing.marsRover.helper.Constants;

/**
 * @author kalfie
 *
 */

@Service
@RequiredArgsConstructor
public class MarsRoverService {


  private final NasaApi nasaApi;
  private final AuditService auditService;

  /**
   * Method responsible of calling the helper class NasaApi that does the call to the NasaApi and
   * also connects to the AuditService in order to save the auditing information in our H2 DB.
   * 
   * @param request
   * @return SearchResponse
   */

  public MarsRoverResponseObject retrieveMarsPhotos(MarsRoverRequest request) {
    Stopwatch stopwatch = Stopwatch.createStarted();
    MarsRoverResponseObject response = nasaApi.getPhotos(request);

    stopwatch.stop();
    long timeElapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);



    AuditNasaCalls auditNasa = AuditNasaCalls.builder()
        .requestMethodName(Constants.METHOD_NAME)
        .responseTime(timeElapsed)
        .createdDate(LocalDateTime.now())
        .build();

    auditService.saveAuditInfo(auditNasa);

    return response;

  }

}
