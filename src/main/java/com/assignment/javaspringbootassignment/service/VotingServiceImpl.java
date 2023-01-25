package com.assignment.javaspringbootassignment.service;

import com.assignment.javaspringbootassignment.entity.Candidate;
import com.assignment.javaspringbootassignment.exceptionHandler.CandidateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VotingServiceImpl implements VotingService{

    @Autowired
    Candidate candidate;

    Map<String,Integer> map = new HashMap<String,Integer>();
    @Override
    public String enterCandidate(String name) {
        if (!name.isEmpty())
            map.put(name,0);
        else
            throw new CandidateNotFoundException("invalid input");
        return name;
    }

    @Override
    public boolean castVote(String name) {
        if (map.containsKey(name))
            map.put(name,map.get(name)+1);
        else
            throw new CandidateNotFoundException("no such candidate exists");
        return true;
    }

    @Override
    public int countVote(String name) {
        if (map.containsKey(name))
            return map.get(name);
        else
            throw new CandidateNotFoundException("no such candidate exists");
    }

    @Override
    public List<Candidate> listVote() {
        List<Candidate> list=new ArrayList<Candidate>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            candidate.setName(entry.getKey());
            candidate.setCount(entry.getValue());
            list.add(candidate);
        }
        return list;
    }

    @Override
    public String getWinner() {
        int count=Integer.MIN_VALUE;
        String winner=" ";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(count<entry.getValue()){
                count=entry.getValue();
                winner=entry.getKey();
            }
        }

        return winner;
    }
}
