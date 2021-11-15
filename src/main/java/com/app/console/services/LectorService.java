package com.app.console.services;

import com.app.console.models.Lector;
import com.app.console.repo.LectorRepo;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LectorService {
    private LectorRepo lectorRepo;

    public LectorService(LectorRepo lectorRepo) {
        this.lectorRepo = lectorRepo;
    }

    public String headOfDepart(String name){
        return lectorRepo.headOfDepart(name);
    }

    public Integer stat(String departmentName, String position){
        return lectorRepo.stat(departmentName, position);
    }

    public Double avgSalary(String depName){
        return lectorRepo.avgSalary(depName);
    }

    public Integer countOfEmployee(String depName){
        return lectorRepo.countOfEmployee(depName);
    }

    public List<String> globalSearch(String name){
        return lectorRepo.globSearch(name);
    }
}
