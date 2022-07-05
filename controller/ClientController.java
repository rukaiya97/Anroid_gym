package com.example.GymSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.GymSystem.Exception.ResourceNotFoundException;
import com.example.GymSystem.model.Client;
import com.example.GymSystem.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("api/Client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    //get all clients

@GetMapping("/")
    public List<Client> getAllClient()
     {
        return clientRepository.findAll();

    }

@PostMapping("/")
    public Client addClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

//update Client
@PutMapping("/{id}")
public ResponseEntity<Client> updateStaff(@PathVariable long id, @RequestBody Client client)
{
    Client cln = clientRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
    cln.setFname(client.getFname());
    cln.setLname(cln.getLname());
    cln.setEmail(cln.getEmail());
    cln.setGender(cln.getGender());
    cln.setTime(cln.getTime());

    Client clt = clientRepository.save(cln);
    return ResponseEntity.ok(clt);
}

//get Client by id
@GetMapping("/{id}")
public ResponseEntity<Client> getStaffById(@PathVariable long id)
{
    Client cln = clientRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
    return ResponseEntity.ok(cln);
}

//delete Client
@DeleteMapping("/{id}")
public ResponseEntity<Map<String,Boolean>> deleteStaff(@PathVariable long id)
{
    Client cln = clientRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
    clientRepository.delete(cln);

    Map<String,Boolean> response = new HashMap<>();
    response.put("Deleted",Boolean.TRUE);
    return ResponseEntity.ok(response);
}


}
