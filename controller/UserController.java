package com.example.GymSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.GymSystem.Exception.ResourceNotFoundException;
import com.example.GymSystem.model.User;
import com.example.GymSystem.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("api/user")
public class UserController {


@Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

     //update user
     @PutMapping("/{id}")
     public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
     {
         User us = userRepo.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));

         us.setName(user.getName());
         us.setPassword(user.getPassword());
         us.setEmail(user.getEmail());

         
         User usr = userRepo.save(us);
         return ResponseEntity.ok(usr);
     }

     //get staff by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getStaffById(@PathVariable long id)
    {
        User us = userRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        return ResponseEntity.ok(us);
    }

    //delete staff
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStaff(@PathVariable long id)
    {
        User us = userRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
        userRepo.delete(us);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
