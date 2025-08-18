package org.shark.todo.sevice;

import java.util.List;
import java.util.Map;

import org.shark.todo.model.dto.TodoDTO;
import org.shark.todo.repository.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   //Spring Container에 TodoService 타입(인터페이스 타입으로 지정해야 함)의 빈 생성
public class TodoServiceImpl implements TodoService {

  //TodoDAO 타입의 빈을 Spring Container에서 가져옵니다.
  @Autowired
  private TodoDAO todoDAO;
  
  
//  @Override
//  public List<TodoDTO> getTodoList() {
//    List<TodoDTO> todoList = todoDAO.todoList();
//    return todoList;   //컨트롤러에게 todoList 반환하기
//  }
  @Override
  public Map<String, Object> getTodoList() {
    List<TodoDTO> todoList = todoDAO.todoList();
    Integer todoCount = todoDAO.todoCount();
    return Map.of("todoList", todoList, "todoCount", todoCount);
  }
  
  @Override
  public TodoDTO getTodoById(Integer tid) {
    if(tid == null || tid <= 0) {
      return null;
    }
    return todoDAO.selectTodoById(tid);
  } 
  
  @Override
  public boolean updateTodo(TodoDTO todo) {
    int updatedCount = todoDAO.updateTodo(todo);
    return updatedCount > 0;
  }
  
  @Override
  public boolean deleteTodo(Integer tid) {
    int deletedCount = todoDAO.deleteTodo(tid);
    return deletedCount > 0;
  }
  
  @Override
  public boolean createTodo(TodoDTO todo) {
    int insertedCount = todoDAO.insertTodo(todo);
    return insertedCount > 0;
  }
  
}




