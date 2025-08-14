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
  <h1>Todo Detail</h1>
  <button onclick="updateForm()">편집</button>
  <script type="text/javascript">
    function updateForm() {
      location.href="${contextPath}/td/edit";
    }
  </script>
  
 <br>
  
  <button onclick="toList()">목록보기</button>
  <script type="text/javascript">
    function toList() {
      location.href="${contextPath}/td/list";
    }
  </script>
  
</body>
</html>