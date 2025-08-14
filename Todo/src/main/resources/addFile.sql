select tid, title, content, created_at
  from tbl_todo;
  
  use db_todo;
  
  insert into tbl_todo(title, content, created_at)
    values('테스트제목', '테스트내용', current_timestamp);
    
    commit;