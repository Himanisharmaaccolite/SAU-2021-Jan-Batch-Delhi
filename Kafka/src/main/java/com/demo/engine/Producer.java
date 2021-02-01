package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, MovieData> kafkaTemplate;

    public void sendMovieData(String movieName,String actor,String actress,int year) {

        MovieData m=new MovieData();
        m.setMovieName(movieName);
        m.setActor(actor);
        m.setActress(actress);
        m.setYear(year);
        logger.info(String.format("#### -> Producing message -> %s", m));
        this.kafkaTemplate.send(TOPIC, m);
    }
}
