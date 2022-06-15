<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.06.2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Form</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/user_update.css" type="text/css">
</head>
<body>
<!-- Body of Form starts -->
<div class="container">
    <form method="post" autocomplete="on" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="update_user">
        <!--First name-->
        <div class="box">
            <label class="fl fontLabel"> First Name: </label>
            <div class="new iconBox">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
            <div class="fr">
                <input type="text" name="firstname" placeholder="First Name"
                       class="textBox" autofocus="on" value="<%= request.getParameter("firstname") %>" >
            </div>
            <div class="clr"></div>
        </div>
        <!--First name-->


        <!--Second name-->
        <div class="box">
            <label class="fl fontLabel"> Lastname: </label>
            <div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
            <div class="fr">
                <input type="text" name="lastname"
                       placeholder="Lastname" class="textBox" value="<%= request.getParameter("lastname")%>">
            </div>
            <div class="clr"></div>
        </div>
        <!--Second name-->

        <!--Username-->
        <div class="box">
            <label class="fl fontLabel"> Username: </label>
            <div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
            <div class="fr">
                <input type="text" name="username"
                       placeholder="Username" class="textBox" value="<%= request.getAttribute("username")  %>">
            </div>
            <div class="clr"></div>
        </div>
        <!--Username-->

        <div><small style="color: red">${username_error}</small></div>

        <!---Phone No.------>
        <div class="box">
            <label class="fl fontLabel"> Phone No.: </label>
            <div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
            <div class="fr">
                <input type="text" name="contact" placeholder="Phone number"
                       class="textBox" value="<%=request.getParameter("contact")%>">
            </div>
            <div class="clr"></div>
        </div>
        <!---Phone No.---->

        <div><small style="color: red">${phone_number_error}</small></div>

        <!---Email ID---->
        <div class="box">
            <label class="fl fontLabel"> Email ID: </label>
            <div class="fl iconBox"><i class="fa fa-envelope" aria-hidden="true"></i></div>
            <div class="fr">
                <input type="email" name="email" placeholder="Email" class="textBox" value="<%= request.getAttribute("email")%>">
            </div>
            <div class="clr"></div>
        </div>
        <!--Email ID----->

        <div><small style="color: red">${email_error}</small></div>

        <!---Password------>
        <div class="box">
            <label class="fl fontLabel"> Password </label>
            <div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
            <div class="fr">
                <input type="Password" name="password" placeholder="Password" class="textBox" value="<%= request.getParameter("password") %>" >
            </div>
            <div class="clr"></div>
        </div>
        <!---Password---->

        <div><small style="color: red">${password_error}</small></div>

        <!--Terms and Conditions------>
        <div class="box terms">
            <input type="checkbox" name="Terms" > &nbsp; I accept the terms and conditions
        </div>
        <!--Terms and Conditions------>


        <!---Submit Button------>
        <div class="box" style="background: #2d3e3f">
            <input type="submit" name="submit" class="submit" value="Push">
        </div>
        <!---Submit Button----->
    </form>
</div>
<!--Body of Form ends--->
</body>
</html>
