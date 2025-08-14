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
  <h1>Detail</h1>
  <button onclick="update()">편집</button>
  <script type="text/javascript">
    function update() {
      location.href="${contextPath}/prac/edit";
    }
  </script>
  
  <br>
  
  <button onclick="toList()">리스트보기</button>
  <script type="text/javascript">
    function toList() {
      location.href="${contextPath}/prac/list";
    }
  </script>
  
</body>
</html>