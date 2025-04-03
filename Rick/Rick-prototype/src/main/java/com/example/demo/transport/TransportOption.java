package com.example.demo.transport;

import com.example.demo.model.TransportOptionResultaat;

import java.util.List;

public interface TransportOption {
    List<TransportOptionResultaat> searchOptions(String from, String to);
}

