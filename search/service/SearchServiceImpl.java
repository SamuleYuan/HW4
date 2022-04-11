package com.example.search.service;



import com.example.search.config.EndpointConfig;
import com.example.search.exception.NotfoundException;
import com.example.search.pojo.City;

import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;


    public SearchServiceImpl(RestTemplate getRestTemplate) {
        this.restTemplate = getRestTemplate;
    }

    @Async
    @Override
    @Retryable(include = IllegalAccessError.class)
    public CompletableFuture<List<Integer>> findCityIdByName(String[] cityArray) {
        City[] cities = restTemplate.getForObject(EndpointConfig.queryWeatherByCity + String.join(",", cityArray), City[].class);
        List<Integer> ans = new ArrayList<>();
        if(ans.isEmpty()) throw new NotfoundException();
        for(City c: cities) {
            if(c != null && c.getWoeid() != null) {
                ans.add(c.getWoeid());
            }
        }
        return CompletableFuture.completedFuture(ans);
    }

    @Override
    //change findcitynamebyid => find weather details by id
    public Map<String, Map> findCityNameById(int id) {
        Map<String, Map> ans = restTemplate.getForObject(EndpointConfig.queryWeatherById + id, HashMap.class);
        return ans;
    }
}
