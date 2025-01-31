package com.springBoot.journalProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UniWebClientModel {

    @JsonProperty("state-province")
    private String state_province;

    @JsonProperty("country")
    private String country;

    @JsonProperty("name")
    private String name;

    @JsonProperty("web_pages")
    private List<String> web_pages;
}
