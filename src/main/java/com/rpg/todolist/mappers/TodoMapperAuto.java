package com.rpg.todolist.mappers;

import com.rpg.todolist.dto.todo.CreateTodoDTO;
import com.rpg.todolist.dto.todo.TodoDTO;
import com.rpg.todolist.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TodoMapperAuto {

    TodoDTO toDTO(Todo todo);

    @Mapping(ignore = true, target = "id")
    Todo toEntity(CreateTodoDTO createTodoDTO);

    void updateEntityFromDTO(TodoDTO todoDTO, @MappingTarget Todo todo);
}
