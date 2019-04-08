<%@ page language="java" contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <%--<jsp:include page="inc/Header.html" />--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin | Dashboard</title>
        <link href="<%=request.getContextPath()%>/css/font-awesome.css" rel="stylesheet">
        <!-- Bootstrap -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <!-- SmartMenus jQuery Bootstrap Addon CSS -->
        <link href="<%=request.getContextPath()%>/css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
        <!-- Product view slider -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.simpleLens.css">
        <!-- slick slider -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick.css">
        <!-- price picker slider -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/nouislider.css">
        <!-- Theme color -->
        <link id="switcher" href="<%=request.getContextPath()%>/css/theme-color/default-theme.css" rel="stylesheet">
        <!-- <link id="switcher" href="<%=request.getContextPath()%>/css/theme-color/bridge-theme.css" rel="stylesheet"> -->
        <!-- Top Slider CSS -->
        <link href="<%=request.getContextPath()%>/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

        <!-- Main style sheet -->
        <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1" >
        <link href="<%=request.getContextPath()%>/css/accordion.css" rel="stylesheet" media="all">


        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="bower_components/morris.js/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">



        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/dist/css/skins/_all-skins.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/iCheck/flat/blue.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<fmt:setLocale value="${Pagelanguage }"/>
<fmt:setBundle var="BundleContent"
               basename="BeautyIt.BP.Resources.Content"/>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
            <!--   <span class="logo-mini"><b>A</b>LT</span> --> <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b><fmt:message key="Users Section"
                                                  bundle="${BundleContent}"/></b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu"
               role="button"> <span class="sr-only"><fmt:message
                    key="Toggle navigation" bundle="${BundleContent}"/></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->

                    <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4  Language and currency -->
                    <li class="dropdown notifications-menu"><a href="#"
                                                               class="dropdown-toggle" data-toggle="dropdown"> <img
                            src="img/flag/<%=request.getAttribute("flag")%>.jpg"
                            alt="<%=request.getAttribute("flag")%> flag"> <%=request.getAttribute("pageLanguageName")%>
                        <span class="caret"></span> <!--  <span class="label label-warning">10</span> -->
                    </a>
                        <ul class="dropdown-menu">
                            <li><a
                                    href="<%=request.getAttribute("PageName")%>?Pagelanguage=en_US&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
                                    src="img/flag/United State.jpg" alt="English Language">
                                <fmt:message key="English" bundle="${BundleContent}"/></a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName")%>?Pagelanguage=hy_AM&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
                                    src="img/flag/Armenia.jpg" alt="Armenian Language"> <fmt:message
                                    key="Armenian" bundle="${BundleContent}"/></a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName")%>?Pagelanguage=ru_RU&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
                                    src="img/flag/Russia.jpg" alt="Russian Language"> <fmt:message
                                    key="Russian" bundle="${BundleContent}"/></a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName")%>?Pagelanguage=ar_LB&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
                                    src="img/flag/Lebanon.jpg" alt="Arabic Language"> <fmt:message
                                    key="Arabic" bundle="${BundleContent}"/></a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName")%>?Pagelanguage=fr_FR&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
                                    src="img/flag/France.jpg" alt="French Language"> <fmt:message
                                    key="French" bundle="${BundleContent}"/></a></li>
                        </ul>
                    </li>
                    <!--   <li class="footer"><a href="#">View all</a></li> -->


                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu"><a href="#"
                                                               class="dropdown-toggle" data-toggle="dropdown"> <i
                            class="fa fa-<%=request.getAttribute("currencySymbol")%>"></i><%=request.getAttribute("PageCurrency")%>
                        <span class="caret"></span> <!--  <span class="label label-warning">10</span> -->
                    </a>
                        <ul class="dropdown-menu">

                            <li><a
                                    href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=EURO"><i
                                    class="fa fa-euro"></i>EURO</a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=RUB"><i
                                    class="fa fa-rouble"></i>RUB</a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=USD"><i
                                    class="fa fa-dollar"></i>USD</a></li>
                            <li><a
                                    href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=DRAM"><i
                                    class="fa fa-money"></i>DRAM</a></li>

                        </ul>
                        <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4  Language and currency -->
                    <li class="dropdown messages-menu"><a href="#"
                                                          class="dropdown-toggle" data-toggle="dropdown"> <i
                            class="fa fa-comment"></i>

                    </a>
                        <ul class="dropdown-menu">
                            <li class="header"><fmt:message key="Support"
                                                            bundle="${BundleContent}"/></li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <!-- start message --> <a href="#">
                                        <div class="pull-left">
                                            <img src="Users/dist/img/user2-160x160.jpg"
                                                 class="img-circle" alt="User Image">
                                        </div>
                                        <h4>
                                            Support Team
                                            <!--   <small><i class="fa fa-clock-o"></i> 5 mins</small> -->
                                        </h4>
                                        <p>Contact Products issues Department</p>
                                        <small>
                                            <!-- <i class="fa fa-clock-o"></i> -->Any issues.
                                        </small>
                                    </a>
                                    </li>
                                    <li>
                                        <!-- start message --> <a href="#">
                                        <div class="pull-left">
                                            <img src="Users/dist/img/user2-160x160.jpg"
                                                 class="img-circle" alt="User Image">
                                        </div>
                                        <h4>
                                            Products Departments
                                            <!--    -->
                                        </h4>
                                        <p>Contact Web site Developer</p>
                                        <small>
                                            <!-- <i class="fa fa-clock-o"></i> -->Report problem with
                                            item.
                                        </small>

                                    </a>
                                    </li>
                                    <li>
                                        <!-- start message --> <a href="#">
                                        <div class="pull-left">
                                            <img src="Users/dist/img/user2-160x160.jpg"
                                                 class="img-circle" alt="User Image">
                                        </div>
                                        <h4>
                                            Developers Team
                                            <!--   <small><i class="fa fa-clock-o"></i> 5 mins</small> -->
                                        </h4>
                                        <p>Contact Information Department</p>
                                        <small>
                                            <!-- <i class="fa fa-clock-o"></i> -->Report about bugs.
                                        </small>
                                    </a>
                                    </li>
                                    <!-- end message -->

                                </ul>
                            </li>
                            <%--  <li class="footer"><a href="#"><fmt:message key="See All Messages" bundle="${BundleContent}" /></a></li> --%>
                        </ul>
                    </li>

                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu"><a href="#"
                                                               class="dropdown-toggle" data-toggle="dropdown"> <i
                            class="fa fa-envelope-o"></i> <span
                            class="label label-success"><%=request.getAttribute("CountMessages")%></span>
                        <!--   <span class="label label-warning">10</span> -->
                    </a>
                        <ul class="dropdown-menu">
                            <li class="header"><fmt:message key="You have"
                                                            bundle="${BundleContent}"/> <%=request.getAttribute("CountMessages")%>
                                <fmt:message
                                        key="messages" bundle="${BundleContent}"/></li>

                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <c:forEach items="${AdminMessagesToUsers}" var="language" varStatus="loop">
                                        <li><a href="#">
                                            <i class="fa fa-circle-o-crayan"></i> <fmt:message
                                                key="${language.messageen}" bundle="${BundleContent}"/>
                                        </a></li>
                                    </c:forEach>

                                </ul>
                            </li>

                            <li class="footer"><a href="#"><fmt:message
                                    key="View all" bundle="${BundleContent}"/></a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <%--	<div class="pull-left image">
                        <img src="<%=request.getContextPath()%>/Users/dist/img/avatar5.png" class="img-circle" alt="User Image">
                    </div>

                    <div class="pull-left info">
                        <p>Alexander Pierce</p>
                          <a href="#"><i class="fa fa-circle text-success"></i> Online</a> -->
                    </div>--%>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header"><fmt:message key="MAIN NAVIGATION"
                                                bundle="${BundleContent}"/></li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Dashboard -->
                <li class=" treeview"><a href="#"> <i
                        class="fa fa-dashboard"></i> <span><fmt:message
                        key="Dashboard" bundle="${BundleContent}"/></span> <span
                        class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
						</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="index.jsp"><i class="fa fa-shopping-cart"></i>
                            <fmt:message key="Buyers Admin Panel" bundle="${BundleContent}"/>
                        </a></li>
                        <li><a href="IsSellerAdminPanel"><i class="fa fa-sellsy"></i>
                            <fmt:message key="Seller panel" bundle="${BundleContent}"/> </a></li>
                    </ul>
                </li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Dashboard -->

                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Profile -->
                <li class="treeview"><a href="#"> <i class="fa fa-user"></i>
                    <span><fmt:message key="Profile" bundle="${BundleContent}"/></span>
                    <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
						</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="Users/UpdateProfile.jsp"><i
                                class="fa fa-wrench"></i>
                            <fmt:message key="Update Profile" bundle="${BundleContent}"/>
                            <span class="pull-right-container"> <small
                                    class="fa fa-circle-o text-red"></small>
								</span> </a></li>
                        <li><a href="pages/charts/morris.html"><i
                                class="fa fa-unlock-alt"></i>
                            <fmt:message key="Change password" bundle="${BundleContent}"/>
                        </a></li>
                        <li><a href="pages/charts/morris.html"><i
                                class="fa fa-image"></i>
                            <fmt:message key="Add Picture" bundle="${BundleContent}"/> </a></li>
                    </ul>
                </li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Profile -->
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Verifications -->
                <li class="treeview"><a href="#"> <i class="fa fa-book"></i>
                    <span><fmt:message key="Verifications"
                                       bundle="${BundleContent}"/></span> <span
                            class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
						</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="pages/UI/general.html"><i
                                class="fa fa-check-circle"></i>
                            <fmt:message key="Email verification" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/UI/icons.html"><i
                                class="fa fa-circle-o"></i>
                            <fmt:message key="Phone verification" bundle="${BundleContent}"/>
                            <span class="pull-right-container"> <small
                                    class="label pull-right bg-yellow"></small>
								</span> </a></li>
                        <li><a href="pages/UI/buttons.html"><i
                                class="fa fa-circle-o"></i>
                            <fmt:message key="Address verification"
                                         bundle="${BundleContent}"/> <span
                                    class="pull-right-container"> <small
                                    class="label pull-right bg-yellow"></small>
								</span> </a></li>

                    </ul>
                </li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Verifications -->
                <li class="treeview"><a href="#">
                    <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Orders -->
                    <i class="fa fa-archive"></i> <span><fmt:message
                        key="Orders" bundle="${BundleContent}"/></span> <span
                        class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
						</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="pages/forms/general.html"><i
                                class="fa fa-buysellads"></i>
                            <fmt:message key="New Orders" bundle="${BundleContent}"/> <span
                                    class="pull-right-container"> <small
                                    class="label pull-right bg-red">5</small></a></li>
                        </span>
                        <li><a href="pages/forms/general.html"><i
                                class="fa fa-buysellads"></i>
                            <fmt:message key="Shipped Orders" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/forms/general.html"><i
                                class="fa fa-buysellads"></i>
                            <fmt:message key="Received orders" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/forms/general.html"><i
                                class="fa fa-archive"></i>
                            <fmt:message key="History" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/forms/advanced.html"><i
                                class="fa fa-undo"></i>
                            <fmt:message key="Returned" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/forms/advanced.html"><i
                                class="fa fa-undo"></i>
                            <fmt:message key="Invoice" bundle="${BundleContent}"/></a></li>

                    </ul>
                </li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Orders -->
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Favorites -->
                <li class="treeview"><a href="#"> <i
                        class="fa fa-heartbeat"></i> <span><fmt:message
                        key="Favorites" bundle="${BundleContent}"/></span> <span
                        class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
						</span>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="pages/tables/simple.html"><i
                                class="fa fa-anchor"></i>
                            <fmt:message key="Products" bundle="${BundleContent}"/></a></li>
                        <li><a href="pages/tables/data.html"><i
                                class="fa fa-diamond"></i>
                            <fmt:message key="Sellers" bundle="${BundleContent}"/></a></li>
                    </ul>
                </li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Favorites -->
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Wish list -->
                <li><a href="pages/calendar.html"> <i class="fa fa-heart"></i>
                    <span><fmt:message key="Wish list"
                                       bundle="${BundleContent}"/></span> <span
                            class="pull-right-container"> <small
                            class="label pull-right bg-red"></small>

						</span>
                </a></li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Wish list -->
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Mailbox -->

                <li class="treeview">
                    <a href="mailbox.html">
                        <i class="fa fa-envelope"></i>Mailbox
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li class="active">
                            <a href="AdminInBox?AdminEmail=<%=request.getAttribute("adminuser")%>"> <i class="fa fa-inbox"></i>Inbox
                                <span class="pull-right-container">
                  <span class="label label-primary pull-right"><%=request.getAttribute("CountAdminMessages")%></span>
                </span>
                            </a>
                        </li>
                        <li><a href="SpyIndex"> <i class="fa fa-book"></i>Spy inbox
                            <span class="pull-right-container">
                  <span class="label label-primary pull-right"></span>
                </span>
                        </a></li>
                        <li><a href="<%=request.getContextPath()%>/AdminCompose"> <i class="fa fa-send-o"></i>Compose
                            <span class="pull-right-container">
                  <span class="label label-primary pull-right"></span>
                </span>
                        </a></li>
                        <li><a href="AdminEmailUsersList"> <i class="fa fa-user"></i>Users List
                            <span class="pull-right-container">
                  <span class="label label-primary pull-right"></span>
                </span>
                        </a></li>

                    </ul>
                </li>

                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Mailbox -->
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Gift cards -->
                <li><a href="pages/calendar.html"> <i class="fa fa-gift"></i>
                    <span><fmt:message key="Gift cards"
                                       bundle="${BundleContent}"/></span>

                </a></li>
                <li><a href="pages/calendar.html"> <i class="fa fa-signal"></i>
                    <span><fmt:message key="Become seller"
                                       bundle="${BundleContent}"/></span>

                </a></li>
                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Gift cards -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>Admin Inbox</small>
            </h1>
            <%-- <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i><fmt:message key="Home" bundle="${BundleContent}" /> </a></li>
                <li class="active"><fmt:message key="Dashboard" bundle="${BundleContent}" /> </li>
            </ol> --%>
        </section>

        <!-- Main content -->
        <section class="content-header">
            <form action="<%=request.getContextPath()%>/AdminInBox" method="get">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Inbox</h3>
                        <!-- /.box-tools -->
                    </div>
                    <!-- /.box-header -->

                    <div class="mailbox-controls">
                        <!-- Check all button -->
                        <div class="btn-group">

                            <button type="submit" class="btn btn-default btn-sm" onclick="getCheckedItems('chkSingle')">
                                <i
                                        class="fa fa-trash-o"></i></button>


                            <%--<button type="button" class="btn btn-default btn-sm"><i
                                    class="fa fa-share"></i></button>--%>
                        </div>

                        <%--<button type="submit" class="btn btn-default btn-sm"><i
                                class="fa fa-reply"></i></button>--%>
                        <!-- /.btn-group -->
                        <button type="button" class="btn btn-default btn-sm" onclick="location.reload();"><i
                                class="fa fa-refresh"></i></button>
                        <%--<div class="pull-right">
                            1-50/200
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-chevron-left"></i></button>
                                <button type="button" class="btn btn-default btn-sm"><i
                                        class="fa fa-chevron-right"></i></button>
                            </div>
                            <!-- /.btn-group -->
                        </div>--%>
                        <!-- /.pull-right -->
                    </div>


                    <div class="table-responsive mailbox-messages">
                        <table class="table table-hover table-striped">
                            <tbody>
                            <c:if test="${requestScope.emailMessages != null}">
                                <c:forEach items="${requestScope.emailMessages}" var="NewsInBox" varStatus="loop">
                                    <tr>
                                        <td>
                                            <input type="checkbox" name="chkSingle" value="${NewsInBox.messageID}"/>
                                        </td>
                                            <script type="text/javascript">
                                                 function getCheckedItems(checkboxName) {
                                                     var checkboxes = document.querySelectorAll('input[name="'+checkboxName+'"]:checked'), values = [];
                                                     Array.prototype.forEach.call(checkboxes, function(el) {
                                                         values.push(el.value);
                                                     });
                                                     return values;
                                                 }
                                             </script>

                                        <c:set var="IMPORTANT" value="${NewsInBox.messageImportant}"/>
                                        <c:choose>
                                            <c:when test="${IMPORTANT == 'true'}">
                                                <td class="mailbox-star">
                                                    <a onClick="window.location='AdminInBox?value=notImportant&EmailId=${NewsInBox.messageID}'">
                                                        <i class="fa fa-star text-yellow"></i></a></td>

                                            </c:when>
                                            <c:otherwise>
                                                <td class="mailbox-star">
                                                    <a onClick="window.location='AdminInBox?value=Important&EmailId=${NewsInBox.messageID}'">
                                                        <i class="fa fa-star-o text-yellow"></i></a></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td class="mailbox-name"><c:out value="${NewsInBox.messageFrom}"/></td>
                                        <td class="mailbox-subject"><b></b> <a
                                                href="<%=request.getContextPath()%>/ReadAdminFromInbox?EmailId=${NewsInBox.messageID}">${NewsInBox.messageTitle}</a>
                                        </td>
                                        <td class="mailbox-date"><c:out value="${NewsInBox.messageDate}"/></td>

                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>

                        <!-- /.table -->
                    </div>
                </div>
            </form>
        </section>

        <!-- /.mail-box-messages -->

        <div class="box-footer no-padding">
            <div class="mailbox-controls">
                <!-- Check all button -->
               <%-- <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                </button>--%>
                <div class="btn-group">
                    <button type="submit" class="btn btn-default btn-sm" onclick="getCheckedItems('chkSingle')"><i
                            class="fa fa-trash-o" ></i></button>
                    <%-- <button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                     <button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>--%>
                </div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-sm" onclick="location.reload();"><i
                        class="fa fa-refresh"></i></button>
                <%--<div class="pull-right">
                    1-50/200
                    &lt;%&ndash;<div class="btn-group">
                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                    </div>&ndash;%&gt;
                    <!-- /.btn-group -->
                </div>--%>
                <!-- /.pull-right -->
            </div>
        </div>
    </section>
        </form>

</div>
<!-- /.content-wrapper -->
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2014-2016 <a
            href="https://adminlte.io">Almsaeed Studio</a>.
    </strong> All rights reserved.
</footer>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
                class="fa fa-home"></i></a></li>
        <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
                class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
                <li><a href="javascript:void(0)"> <i
                        class="menu-icon fa fa-birthday-cake bg-red"></i>

                    <div class="menu-info">
                        <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                        <p>Will be 23 on April 24th</p>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)"> <i
                        class="menu-icon fa fa-user bg-yellow"></i>

                    <div class="menu-info">
                        <h4 class="control-sidebar-subheading">Frodo Updated His
                            Profile</h4>

                        <p>New phone +1(800)555-1234</p>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)"> <i
                        class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                    <div class="menu-info">
                        <h4 class="control-sidebar-subheading">Nora Joined Mailing
                            List</h4>

                        <p>nora@example.com</p>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)"> <i
                        class="menu-icon fa fa-file-code-o bg-green"></i>

                    <div class="menu-info">
                        <h4 class="control-sidebar-subheading">Cron Job 254
                            Executed</h4>

                        <p>Execution time 5 seconds</p>
                    </div>
                </a></li>
            </ul>
            <!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3>
            <ul class="control-sidebar-menu">
                <li><a href="javascript:void(0)">
                    <h4 class="control-sidebar-subheading">
                        Custom Template Design <span
                            class="label label-danger pull-right">70%</span>
                    </h4>

                    <div class="progress progress-xxs">
                        <div class="progress-bar progress-bar-danger"
                             style="width: 70%"></div>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)">
                    <h4 class="control-sidebar-subheading">
                        Update Resume <span class="label label-success pull-right">95%</span>
                    </h4>

                    <div class="progress progress-xxs">
                        <div class="progress-bar progress-bar-success"
                             style="width: 95%"></div>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)">
                    <h4 class="control-sidebar-subheading">
                        Laravel Integration <span
                            class="label label-warning pull-right">50%</span>
                    </h4>

                    <div class="progress progress-xxs">
                        <div class="progress-bar progress-bar-warning"
                             style="width: 50%"></div>
                    </div>
                </a></li>
                <li><a href="javascript:void(0)">
                    <h4 class="control-sidebar-subheading">
                        Back End Framework <span class="label label-primary pull-right">68%</span>
                    </h4>

                    <div class="progress progress-xxs">
                        <div class="progress-bar progress-bar-primary"
                             style="width: 68%"></div>
                    </div>
                </a></li>
            </ul>
            <!-- /.control-sidebar-menu -->

        </div>
        <!-- /.tab-pane -->
        <!-- Stats tab content -->
        <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
            Content
        </div>
        <!-- /.tab-pane -->
        <!-- Settings tab content -->
        <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
                <h3 class="control-sidebar-heading">General Settings</h3>

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Report panel
                        usage <input type="checkbox" class="pull-right" checked>
                    </label>

                    <p>Some information about this general settings option</p>
                </div>
                <!-- /.form-group -->

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Allow mail
                        redirect <input type="checkbox" class="pull-right" checked>
                    </label>

                    <p>Other sets of options are available</p>
                </div>
                <!-- /.form-group -->

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Expose author
                        name in posts <input type="checkbox" class="pull-right" checked>
                    </label>

                    <p>Allow the user to show his name in blog posts</p>
                </div>
                <!-- /.form-group -->

                <h3 class="control-sidebar-heading">Chat Settings</h3>

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Show me as
                        online <input type="checkbox" class="pull-right" checked>
                    </label>
                </div>
                <!-- /.form-group -->

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Turn off
                        notifications <input type="checkbox" class="pull-right">
                    </label>
                </div>
                <!-- /.form-group -->

                <div class="form-group">
                    <label class="control-sidebar-subheading"> Delete chat
                        history <a href="javascript:void(0)" class="text-red pull-right"><i
                                class="fa fa-trash-o"></i></a>
                    </label>
                </div>
                <!-- /.form-group -->
            </form>
        </div>
        <!-- /.tab-pane -->
    </div>
</aside>
<!-- /.control-sidebar -->
<!-- Add the sidebar's background. This div must be placed
immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<%--<jsp:include page="Inc/JQuerySection.jsp" />--%>
<!-- jQuery library -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.smartmenus.bootstrap.js"></script>
<!-- To Slider JS -->
<script src="<%=request.getContextPath()%>/js/sequence.js"></script>
<script src="<%=request.getContextPath()%>/js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/nouislider.js"></script>
<!-- Custom js -->
<script src="<%=request.getContextPath()%>/js/custom.js"></script>
<!-- ./wrapper -->

<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->

<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
</script>
<script>
    $(function () {
        //Enable iCheck plugin for checkboxes
        //iCheck for checkbox and radio inputs
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });

        //Enable check and uncheck all functionality
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });

        //Handle starring for glyphicon and font awesome
        $(".mailbox-star").click(function (e) {
            e.preventDefault();
            //detect type
            var $this = $(this).find("a > i");
            var glyph = $this.hasClass("glyphicon");
            var fa = $this.hasClass("fa");

            //Switch states
            if (glyph) {
                $this.toggleClass("glyphicon-star");
                $this.toggleClass("glyphicon-star-empty");
            }

            if (fa) {
                $this.toggleClass("fa-star");
                $this.toggleClass("fa-star-o");
            }
        });
    });
</script>


</body>
</html>
