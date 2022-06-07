<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.05.2022
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>
<div>Request from: ${pageContext.errorData.requestURI} is failed</div>
<div>Servlet name: ${pageContext.errorData.servletName}</div>
<div>Status code: ${pageContext.errorData.statusCode}</div>
<div>Exception: ${pageContext.exception}</div>
<br>
Message from exception: ${error_msg}
</body>
</html>
