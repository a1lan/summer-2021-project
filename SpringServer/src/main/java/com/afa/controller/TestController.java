package com.afa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.afa.model.CourseEntity;
import com.afa.repositories.CourseRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    CourseRepository repository;

    @GetMapping("/save")
    public void process(){

        repository.saveAndFlush(new CourseEntity("DemonstrationCourse"));
        return;
    }

    @GetMapping("/t")
    public CourseEntity test(){
        return new CourseEntity("Test");
    }


    @GetMapping("/findall")
    public String findAll(){

        String result = "";

        for(CourseEntity cust : repository.findAll()){
            result += cust.getCourse() + "";
        }

        return result;
    }
}



