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
  <h1>Todo List</h1>
  <button onclick="todoWriteForm()">작성하러가기</button>
  <script type="text/javascript">
    function todoWriteForm() {
      location.href="${contextPath}/td/write";
    }
  </script>
  
  <hr>
  
  <table border="1">
    <caption>전체 게시물 개수: ${todoCount}개</caption>
    <tbody>
    <c:forEach items="${todoList}" var="todo">    <%-- todoList의 타입은 List<TodoDTO>이므로 todo의 타입은 todoDTO이다. --%>
      <tr>
        <td><a href="${contextPath}/td/detail?tid=${todo.tid}">${todo.title}</a></td>
        <td>${todo.createdAt}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  
  <script type="text/javascript">
  const deleteError = "${deleteError}";
  if(deleteError !== "") {
    alert(deleteError);
  }
  
  const msg = "${msg}";
  if(msg !== "") {
    alert(msg);
  }
  </script>
  
</body>
</html>




