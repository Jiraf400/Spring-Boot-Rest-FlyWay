package com.jirafik.ulbi.boot.jirafik_ulbitv.Service;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.TodoEntity;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.UserEntity;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Model.Todo;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Repository.TodoRepo;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted()); //*отрицание текущего значения ( смена )
        return Todo.toModel(todoRepo.save(todo));
    }


}
