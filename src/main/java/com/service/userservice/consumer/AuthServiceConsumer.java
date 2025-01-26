package com.service.userservice.consumer;

import com.service.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {


    private UserRepo userRepo;

    @Autowired
    AuthServiceConsumer (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @KafkaListener (topics = "${spring.kafka.topic-json.name}", groupId = " ${spring.kafka.consumer.group-id}")
    public  void listen(Object eventDate){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
