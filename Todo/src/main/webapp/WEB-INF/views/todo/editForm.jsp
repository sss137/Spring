<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
  <h1>Todo Edit Form</h1>
  <form method="post"
        action="${contextPath}/td/update">
        
    <input type="hidden" name="tid" value="${todo.tid}">
        
    <label for="title">제목</label>
    <br>
    <input type="text" id="title" name="title" value="${todo.title}">
    <br>
    
    <label for="content">내용</label>
    <br>
    <textarea id="content" name="content">${todo.content}</textarea>
    <br>
        
    <button type="submit">수정</button>      
  </form>
  
  <hr>
  
  <h1>Todo Delete Form</h1>
  <form method="post"
        action="${contextPath}/td/delete"
        onsubmit="onDelete()">
        
    <input type="hidden" name="tid" value="${todo.tid}">
        
    <button type="submit">삭제</button>      
  </form>
  <script type="text/javascript">
    function onDelete() {
      if(!confirm("현재 게시글을 삭제하시겠습니까?")) {   //취소하면 서브밋 방지하기
        event.preventDefault();
      }
    }
  </script>
  
</body>
</html>



