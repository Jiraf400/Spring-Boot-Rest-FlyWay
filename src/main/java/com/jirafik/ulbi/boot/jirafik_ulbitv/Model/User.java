package com.jirafik.ulbi.boot.jirafik_ulbitv.Model;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());                            //* [] entity -> [] model
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        model.setUsername(entity.getUsername());
        return model;
    }

}
