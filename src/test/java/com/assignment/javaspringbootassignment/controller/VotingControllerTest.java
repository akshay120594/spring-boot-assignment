package com.assignment.javaspringbootassignment.controller;

import com.assignment.javaspringbootassignment.entity.Candidate;
import com.assignment.javaspringbootassignment.service.VotingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VotingControllerTest {
    @Mock
    private VotingService service;

    @InjectMocks
    private VotingController controller;

    @Test
    public void enterCandidate_validInput_returnsCreated() {
        String name = "ram";
        when(service.enterCandidate(name)).thenReturn(name);
        ResponseEntity<String> response = controller.enterCandidate(name);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("candidate added:" + name, response.getBody());
    }

    @Test
    public void castVote_validInput_returnsOk() {
        String name = "shyam";
        when(service.castVote(name)).thenReturn(true);
        ResponseEntity<Boolean> response = controller.castVote(name);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    public void countVote_validInput_returnsVoteCount() {
        String name = "ram";
        when(service.countVote(name)).thenReturn(3);
        ResponseEntity<Integer> response = controller.countVote(name);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(3, response.getBody());
    }

    @Test
    public void listVote_returnsListOfCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("ram", 3));
        candidates.add(new Candidate("shyam", 2));
        when(service.listVote()).thenReturn(candidates);
        ResponseEntity<List<Candidate>> response = controller.listVote();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(candidates, response.getBody());
    }

    @Test
    public void getWinner_validInput_returnsWinnerName() {
        String winner = "ram";
        when(service.getWinner()).thenReturn(winner);
        ResponseEntity<String> response = controller.getWinner();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(winner, response.getBody());
    }
}
