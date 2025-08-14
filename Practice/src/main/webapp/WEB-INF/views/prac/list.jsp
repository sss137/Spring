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
  <h1>List</h1>
  <button onclick="onWriteForm()">작성하기</button>
  <script type="text/javascript">
    function onWriteForm() {
      location.href="${contextPath}/prac/write";
    }
  </script>
  
  <br>
  
  <table border="1">
    <tbody>
      <tr>
        <td><a href="${contextPath}/prac/detail">제목1</a></td>
        <td>내용1</td>
      </tr>
      <tr>
        <td><a href="${contextPath}/prac/detail">제목2</a></td>
        <td>내용2</td>
      </tr>
      <tr>
        <td><a href="${contextPath}/prac/detail">제목3</a></td>
        <td>내용3</td>
      </tr>
    </tbody>
  </table>
  
  
</body>
</html>