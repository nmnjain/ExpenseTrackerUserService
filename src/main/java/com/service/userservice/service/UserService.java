package com.service.userservice.service;

import com.service.userservice.entities.UserInfoDto;
import com.service.userservice.entities.UserInfo;
import com.service.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.function.UnaryOperator;
import java.util.*;

import java.util.function.Function;
import java.util.function.Supplier;

@Service

public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){

        UnaryOperator<UserInfo> updatingUser = user -> {
            return userRepo.save(user);
        };

        Supplier<UserInfo> createUser = () -> {
            return userRepo.save(userInfoDto.tranformToUserInfo());
        };

        UserInfo userInfo = userRepo.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoDtoOpt = userRepo.findByUserId(userInfoDto.getUserId());

        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }



}




