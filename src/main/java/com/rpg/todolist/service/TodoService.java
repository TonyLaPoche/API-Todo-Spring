package com.rpg.todolist.service;

import com.rpg.todolist.dto.CreateTodoDTO;
import com.rpg.todolist.dto.TodoDTO;
import com.rpg.todolist.entity.Todo;
import com.rpg.todolist.mappers.TodoMapper;
import com.rpg.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> getAllTodos() {
        List<TodoDTO> list = new ArrayList<>();
        for (Todo todo : todoRepository.findAll()) {
            TodoDTO dto = TodoMapper.toDTO(todo);
            list.add(dto);
        }
        return list;
    }

    public TodoDTO getTodoById(Long id) {
        return todoRepository.findById(id)
                .map(TodoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public TodoDTO createTodo(CreateTodoDTO createTodoDTO) {
        Todo todo = TodoMapper.toEntity(createTodoDTO);
        todo = todoRepository.save(todo);
        return TodoMapper.toDTO(todo);
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        TodoMapper.updateEntityFromDTO(todoDTO, todo);
        todo = todoRepository.save(todo);
        return TodoMapper.toDTO(todo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo with ID " + id + " not found");
        }
        todoRepository.deleteById(id);
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}

