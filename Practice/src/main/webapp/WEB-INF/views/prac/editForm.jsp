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
  <h1>Edit Form</h1>
  <form method="post"
        action="${contextPath}/prac/update">
        
  <button type="submit">수정</button>
  </form>
  
  <form method="post"
        action="${contextPath}/prac/delete"
        onSubmit="onDelete()">
        
  <button type="submit">삭제</button>
  </form>
  <script type="text/javascript">
    function onDelete() {
      if(!confirm("현재 게시글을 삭제하시겠습니까?")) {
        event.preventDefault();
      }
    }
  </script>
  
</body>
</html>