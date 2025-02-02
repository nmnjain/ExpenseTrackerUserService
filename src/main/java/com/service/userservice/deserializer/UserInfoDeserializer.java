package com.service.userservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.userservice.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public void configure(Map<String, ? >config, boolean isKey){}

    @Override
    public UserInfoDto deserialize(String args0, byte[] args1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user   = null;
        try{
            user = objectMapper.readValue(args1, UserInfoDto.class);
        } catch (Exception e) {
            System.out.println("can not deserailize");
        }
        return user;
    }

    @Override
    public void close(){}

}
