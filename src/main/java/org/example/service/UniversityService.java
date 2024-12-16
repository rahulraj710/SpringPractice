package org.example.service;

import org.example.pojo.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    public RestTemplate restTemplate;

    public List<University> getUniversityList(List<String> countries){
        List<University> allUniversities = new ArrayList<>();
        for (String country : countries){
            String apiUrl = "http://universities.hipolabs.com/search?country=" + country;
            List<University> universities = restTemplate.getForObject(apiUrl, List.class);
            if(universities != null)
                allUniversities.addAll(universities);
//        return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return allUniversities;
    }
}
