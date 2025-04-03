package com.example.demo.planner;

import com.example.demo.model.TransportOptionResultaat;
import com.example.demo.transport.TransportOption;

import java.util.List;

public class TransportPlanner {

    private final TransportOption option;

    public TransportPlanner(TransportOption option) {
        this.option = option;
    }

    public List<TransportOptionResultaat> search(String from, String to) {
        return option.searchOptions(from, to);
    }
}
