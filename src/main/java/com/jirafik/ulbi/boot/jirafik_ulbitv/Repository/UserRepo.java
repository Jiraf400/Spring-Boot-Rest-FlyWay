package com.jirafik.ulbi.boot.jirafik_ulbitv.Repository;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);

}
