package com.jirafik.ulbi.boot.jirafik_ulbitv.Repository;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
