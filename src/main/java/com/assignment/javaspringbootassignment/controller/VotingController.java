package com.assignment.javaspringbootassignment.controller;

import com.assignment.javaspringbootassignment.entity.Candidate;
import com.assignment.javaspringbootassignment.exceptionHandler.CandidateNotFoundException;
import com.assignment.javaspringbootassignment.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VotingController {
    @Autowired
    VotingService service;

    @PostMapping(value ="/entercandidate")
    public ResponseEntity<String> enterCandidate(@RequestParam String name){
        String result=service.enterCandidate(name);
        return new ResponseEntity<String>("candidate added:"+result, HttpStatus.CREATED);

    }
    @PostMapping(value = "/castvote")
    public ResponseEntity<Boolean>castVote(@RequestParam String name){
        boolean result=service.castVote(name);
        return new ResponseEntity<Boolean>(result,HttpStatus.OK);
    }
    @GetMapping(value = "/countvote")
    public ResponseEntity<Integer> countVote(@RequestParam String name) {
        return ResponseEntity.ok(service.countVote(name));
    }

    @GetMapping(value = "/listvote")
    public ResponseEntity<List<Candidate>> listVote() {
        return ResponseEntity.ok(service.listVote());
    }

    @GetMapping(value = "/getwinner")
    public ResponseEntity<String> getWinner() {
        return ResponseEntity.ok(service.getWinner());
    }
}
