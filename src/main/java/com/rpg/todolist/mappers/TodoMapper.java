package com.rpg.todolist.mappers;

import com.rpg.todolist.dto.TodoDTO;
import com.rpg.todolist.entity.Todo;

public class TodoMapper {

    public static TodoDTO toDTO(Todo todo) {
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription());
    }

    public static Todo toEntity(TodoDTO todoDTO) {
        return new Todo(todoDTO.getId(), todoDTO.getTitle(), todoDTO.getDescription());
    }
}

