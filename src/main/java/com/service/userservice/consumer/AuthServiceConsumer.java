package com.service.userservice.consumer;

import com.service.userservice.entities.UserInfoDto;
import com.service.userservice.entities.UserInfo;
import com.service.userservice.repo.UserRepo;
import com.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {

    @Autowired
    private UserService userService;


    private UserRepo userRepo;

    @Autowired
    AuthServiceConsumer (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @KafkaListener (topics = "${spring.kafka.topic-json.name}", groupId = " ${spring.kafka.consumer.group-id}")
    public  void listen(UserInfoDto eventData){
        try{
            userService.createOrUpdateUser(eventData);


        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
