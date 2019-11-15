package com.ing.marsRover.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ing.marsRover.entities.MarsRoverPhoto;
import com.ing.marsRover.entities.MarsRoverRequest;
import com.ing.marsRover.entities.MarsRoverResponseObject;
import com.ing.marsRover.service.MarsRoverService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MarsRoverSearchController {
  
  private final MarsRoverService marsRoverService;
  private MarsRoverResponseObject responseObject;

  /**
   * Endpoint to call the index page and 
   * to fill in the request with the search criteria
   * @param model
   * @return String 
   */
  @RequestMapping
  public String fillRequest(Model model) {
    model.addAttribute("request", new MarsRoverRequest());
    
    return "index";
  }

  /**
   * Endpoint to connect with the service and retrieve the 
   * photos according to the search criteria
   * @param request
   * @return String
   */
  @RequestMapping(path = "/photoSearch", method = RequestMethod.POST)
  public String getAllPhotos(MarsRoverRequest request) {
    responseObject = marsRoverService.retrieveMarsPhotos(request);
    
    return "redirect:/photos";
  }

  /**
   * Endpoint that calls the displayPhotos and displays the
   * results of the search in the page
   * @param model
   * @return String
   */
  @RequestMapping(path = {"/photos"})
  public String displayPhotos(Model model) {
    List<MarsRoverPhoto> list = responseObject.getPhotos();
    model.addAttribute("list", list);
    
    return "displayPhotos";
  }
}
