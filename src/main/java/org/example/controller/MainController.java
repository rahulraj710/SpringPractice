package org.example.controller;

import org.example.pojo.University;
import org.example.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UniversityService universityService;

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getUniversities(@RequestParam(value = "name") List<String> name){
        String apiUrl = "http://universities.hipolabs.com/search?country=" + name;
//        List<University> response = restTemplate.getForObject(apiUrl, List.class);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//
//        ResponseEntity<List<University>> response = restTemplate.exchange(
//                apiUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<University>>() {}
//        );
//
//        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        return new ResponseEntity<>(universityService.getUniversityList(name), HttpStatus.OK);
    }

    @GetMapping("/universities/search")
    public ResponseEntity<List<University>> getUniversities(){
        String apiUrl = "http://universities.hipolabs.com/search";

        ResponseEntity<List<University>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<University>>() {}
        );

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
