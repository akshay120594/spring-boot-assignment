package com.assignment.javaspringbootassignment.service;

import com.assignment.javaspringbootassignment.entity.Candidate;
import com.assignment.javaspringbootassignment.exceptionHandler.CandidateNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VotingServiceImplTest {

    @InjectMocks
    private VotingServiceImpl votingService;

    @Test
    public void enterCandidate_validInput_returnsCandidateName() {
        String name = "ram";
        String result = votingService.enterCandidate(name);
        assertEquals(name, result);
    }

    @Test
    public void enterCandidate_emptyInput_throwsException() {
        assertThrows(CandidateNotFoundException.class, () -> votingService.enterCandidate(""));
    }

    @Test
    public void castVote_validInput_returnsTrue() {
        String name = "ram";
        votingService.enterCandidate(name);
        boolean result = votingService.castVote(name);
        assertTrue(result);
    }

    @Test
    public void castVote_invalidInput_throwsException() {
        assertThrows(CandidateNotFoundException.class, () -> votingService.castVote("Invalid"));
    }

    @Test
    public void countVote_validInput_returnsVoteCount() {
        String name = "ram";
        votingService.enterCandidate(name);
        votingService.castVote(name);
        int result = votingService.countVote(name);
        assertEquals(1, result);
    }

    @Test
    public void countVote_invalidInput_throwsException() {
        assertThrows(CandidateNotFoundException.class, () -> votingService.countVote("Invalid"));
    }

    @Test
    public void getWinner_returnsNameOfWinner() {
        String name1 = "ram";
        String name2 = "shyam";
        votingService.enterCandidate(name1);
        votingService.enterCandidate(name2);
        votingService.castVote(name1);
        votingService.castVote(name1);
        String result = votingService.getWinner();
        assertEquals("ram", result);
    }
}


