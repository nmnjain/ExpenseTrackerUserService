package com.service.userservice.repo;

import com.service.userservice.entities.UserInfoDto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepo extends CrudRepository<UserInfoDto, String> {
    UserInfoDto findByUserId(String userId);

}
