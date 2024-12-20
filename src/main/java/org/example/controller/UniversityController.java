package org.example.controller;

import org.example.pojo.University;
import org.example.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    public UniversityService universityService;

    @GetMapping(value = "/universities", params = "{name}")
    public ResponseEntity<List<University>> getUniversities(@RequestParam(value = "name") List<String> name){
        return new ResponseEntity<>(universityService.getUniversityListByCountry(name), HttpStatus.OK);
    }

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getUniversities(){
        return new ResponseEntity<>(universityService.getUniversityList(), HttpStatus.OK);
    }
}
