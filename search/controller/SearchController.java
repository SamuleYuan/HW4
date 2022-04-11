package com.example.search.controller;

import com.example.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SearchController {

    private final SearchService searchService;
    private final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/weather/search/details")
    public ResponseEntity<?> queryWeatherByCity(@RequestParam(required = true) String[] cities) {
        logger.debug("debug ...");
        return new ResponseEntity<>(searchService.findCityIdByName(cities), HttpStatus.OK);
    }

    @GetMapping("/weather/search/details/{id}")
    public ResponseEntity<?> queryWeatherByCity(@PathVariable int id) {
        logger.debug("debug ...");
        return new ResponseEntity<Map>(searchService.findCityNameById(id), HttpStatus.OK);
    }

}

/**
 *
 * String url = "http://google.com";
 *
 * List<String> params = Arrays.asList("111", "222", "333");
 *
 * Map<String, Object> map = new HashMap<>();
 * map.put("ids[]", params.toArray());
 *
 * restTemplate.exchange(url + "?ids={ids[]}", HttpMethod.GET, null, String.class, map);
 */