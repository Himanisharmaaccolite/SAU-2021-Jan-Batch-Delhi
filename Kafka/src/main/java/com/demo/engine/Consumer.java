package com.demo.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class Consumer {

    HashMap<Integer, HashMap<String,Integer>> trackTrending=new HashMap<Integer,HashMap<String,Integer>>();
    HashMap<Integer,String> topTrending=new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String movie) throws IOException {

        MovieData newMovie = new ObjectMapper().readValue(movie, MovieData.class);

        HashMap<String,Integer> m= new HashMap<>();
        if(trackTrending.containsKey(newMovie.getYear())) {
            m=trackTrending.get(newMovie.getYear());
            m.put(newMovie.getActor(), m.containsKey(newMovie.getActor()) ? m.get(newMovie.getActor()) + 1 : 1);
            if(m.get(newMovie.getActor())>=m.get(topTrending.get(newMovie.getYear())))
            {
                topTrending.put(newMovie.getYear(), newMovie.getActor());
            }
        }
        else
        {
            topTrending.put(newMovie.getYear(), newMovie.getActor());
            m.put(newMovie.getActor(),1);
        }
        trackTrending.put(newMovie.getYear(),m);

        logger.info(String.format("Top Trending Actor of "+ newMovie.getYear() + " is " + topTrending.get(newMovie.getYear()) ));

    }
}
