package com.assignment.javaspringbootassignment.service;

import com.assignment.javaspringbootassignment.entity.Candidate;

import java.util.List;

public interface VotingService {
    public String enterCandidate(String name);
    public boolean castVote(String name);
    public int countVote(String name);
    public List<Candidate> listVote();
    public String getWinner();

}
