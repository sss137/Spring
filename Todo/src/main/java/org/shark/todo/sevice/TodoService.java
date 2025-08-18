package org.shark.todo.sevice;

import java.util.Map;

import org.shark.todo.model.dto.TodoDTO;

public interface TodoService {

  //List<TodoDTO> getTodoList();
  Map<String, Object> getTodoList();
  TodoDTO getTodoById(Integer tid);
  boolean updateTodo(TodoDTO todo);
  boolean deleteTodo(Integer tid);
  boolean createTodo(TodoDTO todo);
  
}
