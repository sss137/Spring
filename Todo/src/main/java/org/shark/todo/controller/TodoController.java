package org.shark.todo.controller;

import java.util.Map;

import org.shark.todo.model.dto.TodoDTO;
import org.shark.todo.sevice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  public String create(@ModelAttribute TodoDTO todo, RedirectAttributes redirectAttr) {
    boolean success = todoService.createTodo(todo);
    redirectAttr.addFlashAttribute("msg", success ? "등록 성공" : "등록 실패");
    return "redirect:/td/list";
  }
  
  @GetMapping("/detail")
  public String detail(@RequestParam(defaultValue = "0") Integer tid, Model model) {
    TodoDTO todo = todoService.getTodoById(tid);
    if(todo == null) {
      model.addAttribute("error", "해당 게시글을 찾을 수 없습니다.");
      return "error/404error";
    }
    model.addAttribute("todo", todo);   //forward 시 모델에 바인딩
    return "todo/detail";
    
  }
  
  @GetMapping("/edit")
  public String editForm(@RequestParam(defaultValue = "0") Integer tid, Model model) {
      TodoDTO todo = todoService.getTodoById(tid);
      if(todo == null) {
        model.addAttribute("error", "해당 게시글을 찾을 수 없습니다.");
        return "error/404error";
      }
      model.addAttribute("todo", todo);   //forward 시 모델에 바인딩
      return "/todo/editForm";
      
  }
  
  @PostMapping("/update")
  public String update(@ModelAttribute TodoDTO todo, RedirectAttributes redirectAttr) {   //@ModelAttribute 생략 가능
    boolean success = todoService.updateTodo(todo);
    redirectAttr.addFlashAttribute("msg", success ? "수정 성공" : "수정 실패") //redirect 시 RedirectAttributes에 플래시로 바인딩
                .addAttribute("tid", todo.getTid());   //쿼리시트링 만들어서 redirect 주소에 추가(?tid=1)
    return "redirect:/td/detail";
  }
  
  @PostMapping("/delete")
  public String delete(@RequestParam(defaultValue = "0") Integer tid, RedirectAttributes redirectAttr) {
    if(tid == null || tid <= 0) {
      redirectAttr.addFlashAttribute("deleteError", "삭제 실패");
      return "redirect:/td/list";
    }
    boolean success = todoService.deleteTodo(tid);
    redirectAttr.addFlashAttribute("msg", success ? "삭제 성공" : "삭제 실패");
    return "redirect:/td/list";
  }
   
}





