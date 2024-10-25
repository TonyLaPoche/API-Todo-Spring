package com.rpg.todolist.mappers;

import com.rpg.todolist.dto.CreateTodoDTO;
import com.rpg.todolist.dto.TodoDTO;
import com.rpg.todolist.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapperAuto {
    TodoMapperAuto MAPPER = Mappers.getMapper(TodoMapperAuto.class);

    TodoDTO toDTO(Todo todo);
    Todo toEntity(CreateTodoDTO createTodoDTO);
    void updateEntityFromDTO(TodoDTO todoDTO, Todo todo);
}
