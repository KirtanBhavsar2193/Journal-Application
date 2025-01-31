package com.springBoot.journalProject.service;

import com.springBoot.journalProject.model.UniWebClientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UniWebClientService {
    private static final String UNI_CLIENT_ENDPOINT ="/search";

    @Autowired
    private WebClient uniWebClient;

    public UniWebClientModel getUniversities(final String country) {
        final MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.add("country",country);

        try {
            return uniWebClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(UNI_CLIENT_ENDPOINT)
                            .queryParams(queryParam).build())
                    .retrieve()
                    .bodyToFlux(UniWebClientModel.class)
                    .blockFirst();
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Data Not Found");
        }
    }
}
