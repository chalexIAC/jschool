<%--
  Created by IntelliJ IDEA.
  User: Роднуля
  Date: 07.04.2017
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/parts/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/parts/menu.jsp"></jsp:include>

<input type="button" value="Добавить" class="addNewCategoryBtn";/>
<div class="categories"></div>

<jsp:include page="/WEB-INF/parts/footer.jsp"></jsp:include>
<script src="static/js/category.js"></script>
</body>
</html>
