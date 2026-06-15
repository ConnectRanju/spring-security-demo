package com.ran.spring_security_example.repository;


import com.ran.spring_security_example.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserInfoRepository extends JpaRepository <UserInfo , Integer> {


    Optional<UserInfo> findByName(String username);

}
