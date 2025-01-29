package com.springBoot.journalProject.service;

import com.springBoot.journalProject.api.response.WeatherResponse;
import com.springBoot.journalProject.cache.AppCache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherService
{
    @Value("${weather.api.key}")
    private String apikey;
//    private static final String API = "http://universities.hipolabs.com/search?country=COUN";

    private final RestTemplate restTemplate;
    private final AppCache appCache;

    public List<WeatherResponse> getWeather(String country)
    {
        String api = appCache.APP_Cache.get("university API").replace("<coun>", country);
        try {
            ResponseEntity<List<WeatherResponse>> response = restTemplate.exchange(
                    api, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<WeatherResponse>>() {});
            return (List<WeatherResponse>) response.getBody();
        }
        catch (Exception e)
        {
        // Log the error and return an empty list
        e.printStackTrace();
        return Collections.singletonList(((WeatherResponse) List.of()));
    }
    }

}
