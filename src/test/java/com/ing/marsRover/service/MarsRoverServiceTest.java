package com.ing.marsRover.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.ing.marsRover.entities.Camera;
import com.ing.marsRover.entities.MarsRoverPhoto;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import com.ing.marsRover.entities.Rover;
import com.ing.marsRover.service.MarsRoverService;
import com.ing.marsRover.service.NasaApi;

/**
 * @author kalfie
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class MarsRoverServiceTest {


  @Mock
  private NasaApi nasaApi;
  
  @Mock
  private AuditService auditService;

  
  @InjectMocks
  private MarsRoverService marsRoverService;

  @Test
  public void retrievesMarsPhotos_valid() {
    String dateType = "sol";
    String dateValue = "1000";
    String camera = "fhaz";
    String name = "curiosity";
    
    MarsRoverRequest request = MarsRoverRequest.builder()
        .dateType(dateType)
        .dateValue(dateValue)
        .camera(camera)
        .name(name)
        .build();

    List<MarsRoverPhoto> photos = asList(MarsRoverPhoto.builder()
        .sol(1000)
        .camera(Camera.builder()
            .name(camera)
            .build())
        .rover(Rover.builder()
            .name(name)
            .build())
        .build());

    MarsRoverResponseObject expectedResponse = MarsRoverResponseObject.builder()
        .photos(photos)
        .build();

    when(nasaApi.getPhotos(request)).thenReturn(expectedResponse);


    MarsRoverResponseObject response = marsRoverService.retrieveMarsPhotos(request);

    assertThat(response).isEqualTo(expectedResponse);

  }
  
  @Test
  public void retrievesMarsPhotos_empty() {
    String dateType = "sol";
    String dateValue = "200";
    String camera = "fhaz";
    String name = "curiosity";
    
    MarsRoverRequest request = MarsRoverRequest.builder()
        .dateType(dateType)
        .dateValue(dateValue)
        .camera(camera)
        .name(name)
        .build();

    MarsRoverResponseObject expectedResponse = MarsRoverResponseObject.builder().build();

    when(nasaApi.getPhotos(request)).thenReturn(expectedResponse);


    MarsRoverResponseObject response = marsRoverService.retrieveMarsPhotos(request);

    assertThat(response).isEqualTo(expectedResponse);

  }

}
