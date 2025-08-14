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
  
  
}
