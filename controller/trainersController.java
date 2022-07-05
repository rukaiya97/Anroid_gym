// package com.example.GymSystem.controller;

// import java.util.HashMap;
// import java.util.Map;

// import com.example.GymSystem.model.trainers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// @CrossOrigin
// @RestController
// @RequestMapping("api/trainers")
// public class trainersController{

// @Autowired
//     private TrainersRepository trainersRepository;







//     //delete staff
// @DeleteMapping("/{id}")
// public ResponseEntity<Map<String,Boolean>> deleteStaff(@PathVariable long id)
// {
//     trainers tln = ((Object) trainersRepository.findById(id))
//     .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
//     trainersRepository.delete(tln);

//     Map<String,Boolean> response = new HashMap<>();
//     response.put("Deleted",Boolean.TRUE);
//     return ResponseEntity.ok(response);
// }

// }