package com.afa.controller;

import com.afa.model.UserEntity;
import com.afa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.afa.model.CourseEntity;
import com.afa.repositories.CourseRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    CourseRepository repository;

    @Autowired
    UserRepository userRepository;

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

    @GetMapping("/findallusers")
    public List<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/finduser/{email}")
    public ResponseEntity findUser(@PathVariable String email){
        UserEntity user = userRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}



