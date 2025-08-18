package org.shark.todo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.shark.todo.model.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDAO {

  @Autowired
  private SqlSessionTemplate sqlSession;  
  
  public List<TodoDTO> todoList() {
    List<TodoDTO> todoList = sqlSession.selectList("org.shark.todo.mapper.TodoMapper.selectTodoList");
    return todoList;
  }
  
  public Integer todoCount() {
    Integer todoCount = sqlSession.selectOne("org.shark.todo.mapper.TodoMapper.selectTodoCount");
    return todoCount;
  }
  
  public TodoDTO selectTodoById(Integer tid) {
    TodoDTO todo = sqlSession.selectOne("org.shark.todo.mapper.TodoMapper.selectTodoById", tid);
    return todo;
  }
  
  public int updateTodo(TodoDTO todo) {
    int updatedCount = sqlSession.update("org.shark.todo.mapper.TodoMapper.updateTodo", todo);
    return updatedCount;
  }
  
  public int deleteTodo(Integer tid) {
    int deletedCount = sqlSession.delete("org.shark.todo.mapper.TodoMapper.deleteTodo", tid);
    return deletedCount;
  }
  
  public int insertTodo(TodoDTO todo) {
    int insertedCount = sqlSession.insert("org.shark.todo.mapper.TodoMapper.insertTodo", todo);
    return insertedCount;
  }
  
}



