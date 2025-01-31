package com.springBoot.journalProject.controller;

import com.springBoot.journalProject.model.UniWebClientModel;
import com.springBoot.journalProject.service.UniWebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/universities")
public class UniWebClientController {

    private final UniWebClientService uniWebClientService;

    @GetMapping("/search")
    public ResponseEntity<UniWebClientModel> getUni(@RequestParam(value = "country") final String country) {

        return ResponseEntity.ok(uniWebClientService.getUniversities(country));
    }
}
