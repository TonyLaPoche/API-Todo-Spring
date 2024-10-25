package com.rpg.todolist.service;

import com.rpg.todolist.dto.todo.CreateTodoDTO;
import com.rpg.todolist.dto.todo.TodoDTO;
import com.rpg.todolist.entity.Todo;
import com.rpg.todolist.mappers.TodoMapperAuto;
import com.rpg.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapperAuto todoMapperAuto;

    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(this.todoMapperAuto::toDTO).toList();
    }

    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        return this.todoMapperAuto.toDTO(todo);
    }

    public TodoDTO createTodo(CreateTodoDTO createTodoDTO) {
        Todo todo = this.todoMapperAuto.toEntity(createTodoDTO);
        this.todoRepository.save(todo);
        return this.todoMapperAuto.toDTO(todo);
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        this.todoMapperAuto.updateEntityFromDTO(todoDTO, todo);
        todo = todoRepository.save(todo);
        return this.todoMapperAuto.toDTO(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

}

