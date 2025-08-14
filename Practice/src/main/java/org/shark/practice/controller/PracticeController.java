package org.shark.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/prac")
@Controller
public class PracticeController {

  @GetMapping("/list")
  public String list() {
    
    return "/prac/list";
  }
  
  @GetMapping("/write")
  public String writeForm() {
    
    return "/prac/writeForm";
  }
  
  @PostMapping("/insert")
  public String insert() {
    
    return "redirect:/prac/list";
  }
  
  @GetMapping("/detail")
  public String detail() {
    
    return "/prac/detail";
  }
  
  @GetMapping("/edit")
  public String editForm() {
    
    return "/prac/editForm";
  }
  
  @PostMapping("/update")
  public String update() {
    
    return "redirect:/prac/detail";
  }
  
  @PostMapping("/delete")
  public String delete() {
    
    return "redirect:/prac/list";
  }
  
}
