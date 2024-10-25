package com.rpg.todolist.mappers;

import com.rpg.todolist.dto.CreateTodoDTO;
import com.rpg.todolist.dto.TodoDTO;
import com.rpg.todolist.entity.Todo;

public class TodoMapper {

    public static TodoDTO toDTO(Todo todo) {
        return new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription());
    }

    public static Todo toEntity(CreateTodoDTO createTodoDTO) {
        return new Todo(null, createTodoDTO.getTitle(), createTodoDTO.getDescription());
    }

    public static void updateEntityFromDTO(TodoDTO todoDTO, Todo todo) {
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
    }
}

