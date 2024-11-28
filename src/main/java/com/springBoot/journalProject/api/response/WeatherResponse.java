package com.springBoot.journalProject.api.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResponse {

    public String country;
    @JsonProperty("web_pages")
    public List<String> webPages;
    @JsonProperty("name")
    public String uniName;
    @JsonProperty("state-province")
    public String stateProvince;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public String getUniName() {
        return uniName;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    @Override
    public String toString() {
        return "WeatherResponse{\n" +
                "Country ='" + country + '\'' +
                ",\n Web Pages=" + webPages +
                ",\n University Name='" + uniName + '\'' +
                ",\n State Province='" + stateProvince + '\'' +
                "\n"+'}';
    }
}