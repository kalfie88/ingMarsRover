package com.ing.marsRover.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ing.marsRover.entities.Camera;
import com.ing.marsRover.entities.MarsRoverPhoto;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import com.ing.marsRover.entities.Rover;
import com.ing.marsRover.service.MarsRoverService;

/**
 * @author kalfie
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class MarsRoverControllerTest {

  @Mock
  private MarsRoverService marsRoverService;

  @InjectMocks
  private MarsRoverController marsRoverController;

  
  @Test
  public void retrievesMarsPhotos_OK() {
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


    when(marsRoverService.retrieveMarsPhotos(request)).thenReturn(expectedResponse);

    ResponseEntity<?> response = marsRoverController.retrieveMarsPhotos(request);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(expectedResponse);

  }
  
  @Test
  public void retrievesMarsPhotos_BAD_REQUEST() {
    
    ResponseEntity<?> response = marsRoverController.retrieveMarsPhotos(null);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

  }

}
