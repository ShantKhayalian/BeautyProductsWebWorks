<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
 <jsp:include page="inc/Header.html"/>
</head>
<fmt:setLocale value="${Pagelanguage }" />
	<fmt:setBundle var="BundleContent"
		basename="BeautyIt.BeautyProducts.Resources.Content" />
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
    <!--   <span class="logo-mini"><b>A</b>LT</span> -->
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b><fmt:message key="Users Section" bundle="${BundleContent}" /></b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only"><fmt:message key="Toggle navigation" bundle="${BundleContent}" /></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
         
          
          
          <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4  Language and currency -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            
              <img src="img/flag/<%=request.getAttribute("flag") %>.jpg" alt="<%=request.getAttribute("flag") %> flag"> <%=request.getAttribute("pageLanguageName") %> <span
											class="caret"></span>
             <!--  <span class="label label-warning">10</span> -->
            </a>
            <ul class="dropdown-menu">
             <li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=en_US&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
													src="img/flag/United State.jpg" alt="English Language">
													<fmt:message key="English" bundle="${BundleContent}" /></a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=hy_AM&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
													src="img/flag/Armenia.jpg" alt="Armenian Language"> <fmt:message
														key="Armenian" bundle="${BundleContent}" /></a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=ru_RU&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
													src="img/flag/Russia.jpg" alt="Russian Language"> <fmt:message
														key="Russian" bundle="${BundleContent}" /></a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=ar_LB&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
													src="img/flag/Lebanon.jpg" alt="Arabic Language"> <fmt:message
														key="Arabic" bundle="${BundleContent}" /></a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=fr_FR&PageCurrency=<%=request.getAttribute("PageCurrency")%>"><img
													src="img/flag/France.jpg" alt="French Language"> <fmt:message
														key="French" bundle="${BundleContent}" /></a></li>
                </ul>
              </li>
            <!--   <li class="footer"><a href="#">View all</a></li> -->
           
         
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               <i class="fa fa-<%= request.getAttribute("currencySymbol")%>"></i><%= request.getAttribute("PageCurrency")%> <span class="caret"></span>
             <!--  <span class="label label-warning">10</span> -->
            </a>
            <ul class="dropdown-menu" >
										
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=EURO"><i
													class="fa fa-euro"></i>EURO</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=RUB"><i
													class="fa fa-rouble"></i>RUB</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=USD"><i
													class="fa fa-dollar"></i>USD</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=DRAM"><i
													class="fa fa-money"></i>DRAM</a></li>

										</ul>
            
               <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4  Language and currency -->
               
                <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-comment"></i>
            
            </a>
            <ul class="dropdown-menu">
            <li class="header"><fmt:message key="Support" bundle="${BundleContent}" /></li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="Users/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                      <!--   <small><i class="fa fa-clock-o"></i> 5 mins</small> -->
                      </h4>
                      <p>Contact Products issues Department</p>
                       <small><!-- <i class="fa fa-clock-o"></i> -->Any issues.</small>
                    </a>
                  </li>
                   <li>
                   
                   <!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="Users/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Products Departments
                      <!--    -->
                      </h4>
                      <p>Contact Web site Developer</p>
                      <small><!-- <i class="fa fa-clock-o"></i> -->Report problem with item.</small>
                      
                    </a>
                  </li>
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="Users/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Developers Team
                      <!--   <small><i class="fa fa-clock-o"></i> 5 mins</small> -->
                      </h4>
                      <p>Contact Information Department</p>
                      <small><!-- <i class="fa fa-clock-o"></i> -->Report about bugs.</small>
                    </a>
                  </li>
                  <!-- end message -->

                </ul>
              </li>
             <%--  <li class="footer"><a href="#"><fmt:message key="See All Messages" bundle="${BundleContent}" /></a></li> --%>
            </ul>
          </li>
          
           <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
               <span class="label label-success">4</span>
            <!--   <span class="label label-warning">10</span> -->
            </a>
            <ul class="dropdown-menu">
              <li class="header"><fmt:message key="You have" bundle="${BundleContent}" /> 4 <fmt:message key="messages" bundle="${BundleContent}" /></li>
              
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  
                </ul>
              </li>
              
              <li class="footer"><a href="#"><fmt:message key="View all" bundle="${BundleContent}" /></a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          
          
        <%--   <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
            <!--   <span class="label label-warning">10</span> -->
            </a>
            <ul class="dropdown-menu">
              <li class="header"><fmt:message key="Support" bundle="${BundleContent}" /></li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  
                </ul>
              </li>
              
              <li class="footer"><a href="#"><fmt:message key="View all" bundle="${BundleContent}" /></a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="Users/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Alexander Pierce</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="Users/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
               <!--  <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div> -->
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat"><fmt:message key="Profile" bundle="${BundleContent}" /></a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat"><fmt:message key="Sign out" bundle="${BundleContent}" /></a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div> --%>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<%=request.getContextPath() %>/Users/dist/img/avatar5.png" class="img-circle" alt="User Image">
        </div>
		
        <div class="pull-left info">
          <p>Alexander Pierce</p>
         <!--  <a href="#"><i class="fa fa-circle text-success"></i> Online</a> -->
        </div>
      </div>
   
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header"><fmt:message key="MAIN NAVIGATION" bundle="${BundleContent}" /></li>
        <li >
          <a href="#">
            <i class="fa fa-dashboard"></i> <span><fmt:message key="Dashboard" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li ><a href="index.jsp"><i class="fa fa-shopping-cart"></i><fmt:message key="Buyers Admin Panel" bundle="${BundleContent}" /> </a></li>
           <li><a href="IsSellerAdminPanel"><i class="fa fa-sellsy"></i><fmt:message key="Seller panel" bundle="${BundleContent}" />  </a></li> 
          </ul>
        </li>
      
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-user"></i>
            <span><fmt:message key="Profile" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="active treeview">
            <li class="active"><a href="pages/charts/chartjs.html"><i class="fa fa-wrench"></i><fmt:message key="Update Profile" bundle="${BundleContent}" />
            <span class="pull-right-container">
              <small class="fa fa-circle-o text-red"></small>
              </span> </a></li>
            <li><a href="pages/charts/morris.html"><i class="fa fa-unlock-alt"></i><fmt:message key="Change password" bundle="${BundleContent}" /> </a></li>
             <li><a href="pages/charts/morris.html"><i class="fa fa-image"></i><fmt:message key="Add Picture" bundle="${BundleContent}" /> </a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-book"></i>
            <span><fmt:message key="Verifications" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/UI/general.html"><i class="fa fa-check-circle"></i><fmt:message key="Email verification" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/UI/icons.html"><i class="fa fa-circle-o"></i><fmt:message key="Phone verification" bundle="${BundleContent}" />
             <span class="pull-right-container">
              <small class="label pull-right bg-yellow"></small>
              </span> </a>
              </li>
            <li><a href="pages/UI/buttons.html"><i class="fa fa-circle-o"></i><fmt:message key="Address verification" bundle="${BundleContent}" /> <span class="pull-right-container">
              <small class="label pull-right bg-yellow"></small>
              </span>
              </a></li>

          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-archive"></i> <span><fmt:message key="Orders" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
           <li><a href="pages/forms/general.html"><i class="fa fa-buysellads"></i><fmt:message key="New Orders" bundle="${BundleContent}" />
             <span class="pull-right-container">
               <small class="label pull-right bg-red">5</small></a></li>
            </span>
            <li><a href="pages/forms/general.html"><i class="fa fa-buysellads"></i><fmt:message key="Shipped Orders" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/forms/general.html"><i class="fa fa-buysellads"></i><fmt:message key="Received orders" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/forms/general.html"><i class="fa fa-archive"></i><fmt:message key="History" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/forms/advanced.html"><i class="fa fa-undo"></i><fmt:message key="Returned" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/forms/advanced.html"><i class="fa fa-undo"></i><fmt:message key="Invoices" bundle="${BundleContent}" /></a></li>
        
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-heartbeat"></i> <span><fmt:message key="Favorites" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/tables/simple.html"><i class="fa fa-anchor"></i><fmt:message key="Products" bundle="${BundleContent}" /></a></li>
            <li><a href="pages/tables/data.html"><i class="fa fa-diamond"></i><fmt:message key="Sellers" bundle="${BundleContent}" /></a></li>
          </ul>
        </li>
        <li>
          <a href="pages/calendar.html">
            <i class="fa fa-heart"></i> <span><fmt:message key="Wish list" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
             
            </span>
          </a>
        </li>
        <li>
          <a href="pages/mailbox/mailbox.html">
            <i class="fa fa-envelope"></i> <span><fmt:message key="Mailbox" bundle="${BundleContent}" /></span>
            <span class="pull-right-container">
              <small class="label pull-right bg-yellow">12</small>
              <small class="label pull-right bg-green">16</small>
              <small class="label pull-right bg-red">5</small>
            </span>
          </a>
        </li>
 <li>
          <a href="pages/calendar.html">
            <i class="fa fa-gift"></i> <span><fmt:message key="Gift cards" bundle="${BundleContent}" /></span>
          
          </a>
        </li>
        <li>
          <a href="pages/calendar.html">
            <i class="fa fa-signal"></i> <span><fmt:message key="Become seller" bundle="${BundleContent}" /></span>
          
          </a>
        </li>
       <!--  
        <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Examples</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/examples/invoice.html"><i class="fa fa-circle-o"></i> Invoice</a></li>
            <li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i> Profile</a></li>
            <li><a href="pages/examples/login.html"><i class="fa fa-circle-o"></i> Login</a></li>
            <li><a href="pages/examples/register.html"><i class="fa fa-circle-o"></i> Register</a></li>
            <li><a href="pages/examples/lockscreen.html"><i class="fa fa-circle-o"></i> Lockscreen</a></li>
            <li><a href="pages/examples/404.html"><i class="fa fa-circle-o"></i> 404 Error</a></li>
            <li><a href="pages/examples/500.html"><i class="fa fa-circle-o"></i> 500 Error</a></li>
            <li><a href="pages/examples/blank.html"><i class="fa fa-circle-o"></i> Blank Page</a></li>
            <li><a href="pages/examples/pace.html"><i class="fa fa-circle-o"></i> Pace Page</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-share"></i> <span>Multilevel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
            <li class="treeview">
              <a href="#"><i class="fa fa-circle-o"></i> Level One
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                <li class="treeview">
                  <a href="#"><i class="fa fa-circle-o"></i> Level Two
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
          </ul>
        </li>
        <li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
      </ul> -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
     

        </section>
        <!-- /.Left col -->
     

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          <!-- /.form-group -->

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
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

<!-- jQuery 3 -->
<script src="Users/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="Users/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="Users/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="Users/bower_components/raphael/raphael.min.js"></script>
<script src="Users/bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="Users/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="Users/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="Users/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="Users/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="Users/bower_components/moment/min/moment.min.js"></script>
<script src="Users/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="Users/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="Users/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="Users/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="Users/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="Users/dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="Users/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Users/dist/js/demo.js"></script>
</body>
</html>
