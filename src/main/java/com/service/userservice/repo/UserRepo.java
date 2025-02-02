package com.service.userservice.repo;

import com.service.userservice.entities.UserInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends CrudRepository<UserInfo, String> {
    Optional <UserInfo> findByUserId(String userId);

}
