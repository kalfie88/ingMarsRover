package com.ing.marsRover.enums;

/**
 * @author kalfie
 *
 */
public enum SearchCriteriaEnum {
  NAME("name"), CAMERA("camera"), API_KEY("api_key");

  String criteria;

  SearchCriteriaEnum(String criteria) {
    this.criteria = criteria;
  }


  public String getCriteria() {
    return this.criteria;
  }
}
