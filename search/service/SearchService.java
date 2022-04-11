package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public interface SearchService {
    CompletableFuture<List<Integer>> findCityIdByName(String[] cities);
    Map<String, Map> findCityNameById(int id);

}
