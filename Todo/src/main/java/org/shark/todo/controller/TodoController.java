package org.shark.todo.controller;

import java.util.Map;

import org.shark.todo.sevice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/td")
@Controller
public class TodoController {
  
  //TodoService 타입의 빈을 Spring Container에서 가져오기
  @Autowired
  private TodoService todoService;
 
  @GetMapping("/list")
  public String list(Model model) {
    Map<String, Object> map = todoService.getTodoList();
    model.addAttribute("todoList", map.get("todoList"));   //화면에서 확인할 수 있도록 모델에 바인딩
    model.addAttribute("todoCount", map.get("todoCount")); //화면에서 확인할 수 있도록 모델에 바인딩
//    System.out.println("todoList: " + map.get("todoList"));
//    System.out.println("todoCount: " + map.get("todoCount"));
    return "todo/list";
  }
  
  @GetMapping("/write")
  public String writeForm() {
    
    return "todo/writeFrom";
  }
  
  @PostMapping("/create")
  public String create() {
    
    return "redirect:/td/list";
  }
  
  @GetMapping("/detail")
  public String detail() {
    
    return "todo/detail";
  }
  
  @GetMapping("/edit")
  public String editForm() {
    
    return "/todo/editForm";
  }
  
  @PostMapping("/update")
  public String update() {
    
    return "redirect:/td/detail";
  }
  
  @PostMapping("/delete")
  public String delete() {
    
    return "redirect:/td/list";
  }
  
}





