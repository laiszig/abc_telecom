package com.laiszig.abc_telecom_service.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
