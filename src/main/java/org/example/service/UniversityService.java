    package org.example.service;

import org.example.pojo.University;

import java.util.List;

public interface UniversityService {
    public List<University> getUniversityList();
    public List<University> getUniversityListByCountry(List<String> countries);
}
