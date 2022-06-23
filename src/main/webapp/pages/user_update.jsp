<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.06.2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<fmt:setLocale value="uz" scope="session"/>
<fmt:setBundle basename="prop.message"/>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>cms dashboard
    </title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/bootstrap.min.css">
    <!----css3---->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/custom.css">
    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%--    <link rel="stylesheet" href="css/user_update.css" type="text/css">--%>
    <!--google material icon-->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<body>


<div class="wrapper">


    <div class="body-overlay"></div>


    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><img src="${pageContext.request.contextPath}/pages/img/logo.png" class="img-fluid"/><span><fmt:message key="label.admin"/></span></h3>
        </div>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="#" class="dashboard"><i class="material-icons">dashboard</i><span><fmt:message
                        key="label.dashboard"/></span></a>
            </li>

            <div class="small-screen navbar-display">
                <li class="dropdown d-lg-none d-md-block d-xl-none d-sm-block">
                    <a href="#homeSubmenu0" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        <i class="material-icons">notifications</i><span> 4 notification</span></a>
                    <ul class="collapse list-unstyled menu" id="homeSubmenu0">
                        <li>
                            <a href="#">You have 5 new messages</a>
                        </li>
                        <li>
                            <a href="#">You're now friend with Mike</a>
                        </li>
                        <li>
                            <a href="#">Wish Mary on her birthday!</a>
                        </li>
                        <li>
                            <a href="#">5 warnings in Server Console</a>
                        </li>
                    </ul>
                </li>

                <li class="d-lg-none d-md-block d-xl-none d-sm-block">
                    <a href="#"><i class="material-icons">apps</i><span>apps</span></a>
                </li>

                <li class="d-lg-none d-md-block d-xl-none d-sm-block">
                    <a href="#"><i class="material-icons">person</i><span>user</span></a>
                </li>

                <li class="d-lg-none d-md-block d-xl-none d-sm-block">
                    <a href="#"><i class="material-icons">settings</i><span>setting</span></a>
                </li>
            </div>


            <li class="dropdown">
                <a href="#homeSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="material-icons">aspect_ratio</i><span><fmt:message key="label.books"/></span></a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu1">
                    <li>
                        <a href="#">Home 1</a>
                    </li>
                    <li>
                        <a href="#">Home 2</a>
                    </li>
                    <li>
                        <a href="#">Home 3</a>
                    </li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="material-icons">apps</i><span><fmt:message key="label.author"/></span></a>
                <ul class="collapse list-unstyled menu" id="pageSubmenu2">
                    <li>
                        <a href="#">Page 1</a>
                    </li>
                    <li>
                        <a href="#">Page 2</a>
                    </li>
                    <li>
                        <a href="#">Page 3</a>
                    </li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#pageSubmenu3" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="material-icons">equalizer</i><span><fmt:message key="label.genre"/></span></a>
                <ul class="collapse list-unstyled menu" id="pageSubmenu3">
                    <li>
                        <a href="#">Page 1</a>
                    </li>
                    <li>
                        <a href="#">Page 2</a>
                    </li>
                    <li>
                        <a href="#">Page 3</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#pageSubmenu4" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="material-icons">extension</i><span><fmt:message key="label.users"/></span></a>
                <ul class="collapse list-unstyled menu" id="pageSubmenu4">
                    <li>
                        <a href="pages/admin/user.jsp" style="text-transform: none"><fmt:message
                                key="label.user_information"/></a>
                    </li>
                    <li>
                        <a href="#">Page 2</a>
                    </li>
                    <li>
                        <a href="#">Page 3</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#pageSubmenu7" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="material-icons">content_copy</i><span><fmt:message key="label.pages"/></span></a>
                <ul class="collapse list-unstyled menu" id="pageSubmenu7">
                    <li>
                        <a href="#">Page 1</a>
                    </li>
                    <li>
                        <a href="#">Page 2</a>
                    </li>
                    <li>
                        <a href="#">Page 3</a>
                    </li>
                </ul>
            </li>
        </ul>

    </nav>

    <!-- Page Content  -->
    <div id="content">

        <div class="top-navbar">
            <nav class="navbar navbar-expand-lg">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="d-xl-block d-lg-block d-md-mone d-none">
                        <span class="material-icons">arrow_back_ios</span>
                    </button>

                    <a class="navbar-brand" href="#"><fmt:message key="label.dashboard"/></a>

                    <button class="d-inline-block d-lg-none ml-auto more-button" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="material-icons">more_vert</span>
                    </button>

                    <div class="collapse navbar-collapse d-lg-block d-xl-block d-sm-none d-md-none d-none"
                         id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="dropdown nav-item active">
                                <a href="#" class="nav-link" data-toggle="dropdown">
                                    <span class="material-icons">notifications</span>
                                    <span class="notification">4</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">You have 5 new messages</a>
                                    </li>
                                    <li>
                                        <a href="#">You're now friend with Mike</a>
                                    </li>
                                    <li>
                                        <a href="#">Wish Mary on her birthday!</a>
                                    </li>
                                    <li>
                                        <a href="#">5 warnings in Server Console</a>
                                    </li>

                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span class="material-icons">apps</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span class="material-icons">person</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span class="material-icons">settings</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>


        <div class="main-content">


            <form method="post" autocomplete="on" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="update_user">
                <!--First name-->
                <div class="box">
                    <div class="new iconBox">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </div>
                    <div class="fr">
                        <label class="fl fontLabel"> First Name: </label>
                        <label>
                            <input type="text" name="firstname" placeholder="First Name"
                                   class="textBox" autofocus="on" value=""><!-- <%= request.getParameter("firstname") %> -->
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!--First name-->


                <!--Second name-->
                <div class="box">
                    <div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
                    <div class="fr">
                        <label>
                            <label class="fl fontLabel"> Lastname: </label>
                            <label>
                                <input type="text" name="lastname"
                                       placeholder="Lastname" class="textBox" value=""><!-- <%= request.getParameter("lastname")%> -->
                            </label>
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!--Second name-->

                <!--Username-->
                <div class="box">
                    <div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
                    <div class="fr">
                        <label class="fl fontLabel"> Username: </label>
                        <label>
                            <input type="text" name="username"
                            placeholder="Username" class="textBox" value=""> <!-- <%= request.getAttribute("username")  %> -->
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!--Username-->

                <div><small style="color: red">${username_error}</small></div>

                <!---Phone No.------>
                <div class="box">
                    <div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
                    <div class="fr">
                        <label class="fl fontLabel"> Phone Number: </label>
                        <label>
                            <input type="text" name="contact" placeholder="Phone number"
                            class="textBox" value=""> <!-- <%=request.getParameter("contact")%> -->
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!---Phone No.---->

                <div><small style="color: red">${phone_number_error}</small></div>

                <!---Email ID---->
                <div class="box">
                    <div class="fl iconBox"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                    <div class="fr">
                        <label class="fl fontLabel"> Email: </label>
                        <label>
                            <input type="email" name="email" placeholder="Email" class="textBox"
                                   value=""><!-- <%= request.getAttribute("email")%> -->
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!--Email ID----->

                <div><small style="color: red">${email_error}</small></div>

                <!---Password------>
                <div class="box">
                    <div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
                    <div class="fr">
                        <label class="fl fontLabel"> Password </label>
                        <label>
                            <input type="Password" name="password" placeholder="Password" class="textBox"
                                   value=""><!-- <%= request.getParameter("password") %> -->
                        </label>
                    </div>
                    <div class="clr"></div>
                </div>
                <!---Password---->

                <div><small style="color: red">${password_error}</small></div>

                <!--Terms and Conditions------>
                <div class="box terms">
                    <label>
                        <input type="checkbox" name="Terms">
                    </label> &nbsp; I accept the terms and conditions
                </div>
                <!--Terms and Conditions------>


                <!---Submit Button------>
                <div class="box" style="background: #2d3e3f">
                    <input type="submit" name="submit" class="submit" value="Push">
                </div>
                <!---Submit Button----->
            </form>

            <footer class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <nav class="d-flex">
                                <ul class="m-0 p-0">
                                    <li>
                                        <a href="#">
                                            Home
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            Company
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            Portfolio
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            Blog
                                        </a>
                                    </li>
                                </ul>
                            </nav>

                        </div>
                        <div class="col-md-6">
                            <p class="copyright d-flex justify-content-end"> &copy 2021 Design by
                                <a href="#">Vishweb Design</a> BootStrap Admin Dashboard
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="pages/js/jquery-3.3.1.slim.min.js"></script>
<script src="pages/js/popper.min.js"></script>
<script src="pages/js/bootstrap.min.js"></script>
<script src="pages/js/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
            $('#content').toggleClass('active');
        });

        $('.more-button,.body-overlay').on('click', function () {
            $('#sidebar,.body-overlay').toggleClass('show-nav');
        });

    });
</script>

</body>
</html>


