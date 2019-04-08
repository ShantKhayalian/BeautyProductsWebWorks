<%@ page language="java" contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%--<jsp:include page="Inc/Header.jsp" />--%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BP | Account Page</title>

	<!-- Font awesome -->
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
	<!-- Top Slider CSS -->
	<link href="<%=request.getContextPath()%>/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

	<!-- Main style sheet -->
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">

	<!-- Google Font -->
	<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>


	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<fmt:setLocale value="${Pagelanguage }" />
	<fmt:setBundle var="BundleContent"
		basename="BeautyIt.BP.Resources.Content" />
	<!-- wpf loader Two -->
	<div id="wpf-loader-two">
		<div class="wpf-loader-two-inner">
			<span><fmt:message key="Loading" bundle="${BundleContent}" /></span>
		</div>
	</div>
	<!-- / wpf loader Two -->
	<!-- SCROLL TOP BUTTON -->
	<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
	<!-- END SCROLL TOP BUTTON -->


	<!-- Start header section -->
	<header id="aa-header">
		<!-- start header top  -->
		<div class="aa-header-top">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-top-area">
							<!-- start header top left -->
							<div class="aa-header-top-left">
								<!-- start language -->
								<%--  <jsp:include page="Inc/EngLang.jsp" />  --%>

								<div class="aa-language">
									<div class="dropdown">

										<a class="btn dropdown-toggle" href="#" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true"> <img
											src="img/flag/<%=request.getAttribute("flag") %>.jpg" alt="<%=request.getAttribute("flag") %> flag"> <%=request.getAttribute("pageLanguageName") %> <span
											class="caret"></span>
										</a>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">

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
									</div> 
								</div>
								<!-- / language -->

								<!-- start currency -->
								<%-- <jsp:include page="Inc/EngCurrency.jsp" /> --%>

								<div class="aa-currency">
									<div class="dropdown">

										<a class="btn dropdown-toggle" href="#" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">
											
											 <i
											class="fa fa-<%= request.getAttribute("currencySymbol")%>"></i><%= request.getAttribute("PageCurrency")%> <span class="caret"></span>
										</a>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
										
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=EURO"><i
													class="fa fa-euro"></i>EURO</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=RUB"><i
													class="fa fa-rouble"></i>RUB</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=USD"><i
													class="fa fa-dollar"></i>USD</a></li>
											<li><a href="<%=request.getAttribute("PageName") %>?Pagelanguage=${Pagelanguage}&PageCurrency=DRAM"><i
													class="fa fa-money"></i>DRAM</a></li>

										</ul>

									</div>
								</div>

								<!-- / currency -->
								<!-- start cellphone -->
								<jsp:include page="Inc/HeadPhone.jsp" />
								<!-- / cellphone -->
							</div>
							<!-- / header top left -->
							<%-- <jsp:include page="Inc/AccountSection.jsp" /> --%>
							<div class="aa-header-top-right">
								<ul class="aa-head-top-nav-right">
									<li><a href="#"><fmt:message key="SonBP"
												bundle="${BundleContent}" /></a></li>
									<li class="hidden-xs"><a href="Register?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"><fmt:message
												key="Register" bundle="${BundleContent}" /></a></li>
									<li><a href="" data-toggle="modal"
										data-target="#login-modal"><fmt:message key="Sign in"
												bundle="${BundleContent}" /></a></li>

								</ul>

							</div>
							<!-- / header top  -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- start header bottom  -->
		<div class="aa-header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-bottom-area">
							<!-- logo  -->
							<%-- 	<jsp:include page="Inc/HeadLogo.jsp" /> --%>
							<div class="aa-logo">
								<!-- Text based logo -->
								<a href="BP?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"> <span class="fa fa-shopping-cart"></span>
									<p>
										BP <strong><fmt:message key="Stores"
												bundle="${BundleContent}" /></strong> <span><fmt:message
												key="Your Shopping Partner" bundle="${BundleContent}" /></span>
									</p>
								</a>
								<!-- img based logo -->
								<!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
							</div>
							<!-- / logo  -->
							<!-- cart box -->
							<jsp:include page="Inc/CartBox.jsp" />
							<!-- / cart box -->
							<!-- search box -->
							<%-- <jsp:include page="Inc/SearchBox.jsp" /> --%>
							<div class="aa-search-box">
								<form action="">
									<input type="text" name="" id=""
										placeholder="<fmt:message key="Search here" bundle="${BundleContent}" />">
									<button type="submit">
										<span class="fa fa-search"></span>
									</button>
								</form>
							</div>

							<!-- / search box -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- / header bottom  -->
	</header>
	<!-- / header section -->
  <!-- menu -->
  <section id="menu">
    <div class="container">
      <div class="menu-area">
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>          
          </div>
          <div class="navbar-collapse collapse">
            <!-- Left nav -->
            <ul class="nav navbar-nav">
              <li><a href="index.html">Home</a></li>
              <li><a href="#">Men <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">Casual</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">Formal</a></li>
                  <li><a href="#">Standard</a></li>                                                
                  <li><a href="#">T-Shirts</a></li>
                  <li><a href="#">Shirts</a></li>
                  <li><a href="#">Jeans</a></li>
                  <li><a href="#">Trousers</a></li>
                  <li><a href="#">And more.. <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>                                      
                    </ul>
                  </li>
                </ul>
              </li>
              <li><a href="#">Women <span class="caret"></span></a>
                <ul class="dropdown-menu">  
                  <li><a href="#">Kurta & Kurti</a></li>                                                                
                  <li><a href="#">Trousers</a></li>              
                  <li><a href="#">Casual</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">Formal</a></li>                
                  <li><a href="#">Sarees</a></li>
                  <li><a href="#">Shoes</a></li>
                  <li><a href="#">And more.. <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>
                      <li><a href="#">And more.. <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Rings</a></li>
                          <li><a href="#">Earrings</a></li>
                          <li><a href="#">Jewellery Sets</a></li>
                          <li><a href="#">Lockets</a></li>
                          <li class="disabled"><a class="disabled" href="#">Disabled item</a></li>                       
                          <li><a href="#">Jeans</a></li>
                          <li><a href="#">Polo T-Shirts</a></li>
                          <li><a href="#">SKirts</a></li>
                          <li><a href="#">Jackets</a></li>
                          <li><a href="#">Tops</a></li>
                          <li><a href="#">Make Up</a></li>
                          <li><a href="#">Hair Care</a></li>
                          <li><a href="#">Perfumes</a></li>
                          <li><a href="#">Skin Care</a></li>
                          <li><a href="#">Hand Bags</a></li>
                          <li><a href="#">Single Bags</a></li>
                          <li><a href="#">Travel Bags</a></li>
                          <li><a href="#">Wallets & Belts</a></li>                        
                          <li><a href="#">Sunglases</a></li>
                          <li><a href="#">Nail</a></li>                       
                        </ul>
                      </li>                   
                    </ul>
                  </li>
                </ul>
              </li>
              <li><a href="#">Kids <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">Casual</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">Formal</a></li>
                  <li><a href="#">Standard</a></li>                                                
                  <li><a href="#">T-Shirts</a></li>
                  <li><a href="#">Shirts</a></li>
                  <li><a href="#">Jeans</a></li>
                  <li><a href="#">Trousers</a></li>
                  <li><a href="#">And more.. <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Sleep Wear</a></li>
                      <li><a href="#">Sandals</a></li>
                      <li><a href="#">Loafers</a></li>                                      
                    </ul>
                  </li>
                </ul>
              </li>
              <li><a href="#">Sports</a></li>
             <li><a href="#">Digital <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="#">Camera</a></li>
                  <li><a href="#">Mobile</a></li>
                  <li><a href="#">Tablet</a></li>
                  <li><a href="#">Laptop</a></li>                                                
                  <li><a href="#">Accesories</a></li>                
                </ul>
              </li>
              <li><a href="#">Furniture</a></li>            
              <li><a href="blog-archive.html">Blog <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="blog-archive.html">Blog Style 1</a></li>
                  <li><a href="blog-archive-2.html">Blog Style 2</a></li>
                  <li><a href="blog-single.html">Blog Single</a></li>                
                </ul>
              </li>
              <li><a href="contact.html">Contact</a></li>
              <li><a href="#">Pages <span class="caret"></span></a>
                <ul class="dropdown-menu">                
                  <li><a href="product.html">Shop Page</a></li>
                  <li><a href="product-detail.html">Shop Single</a></li>                
                  <li><a href="404.html">404 Page</a></li>                
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div> 
      </div>
    </div>
  </section>
  <!-- / menu -->  
 
  <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
    <img src="img/register/Register.png" alt="fashion img">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2><fmt:message key="Account Page" bundle="${BundleContent}"/></h2>
        <ol class="breadcrumb">
          <li><a href="index.html"><fmt:message key="Home" bundle="${BundleContent}"/></a></li>                   
          <li class="active"><fmt:message key="Account" bundle="${BundleContent}"/></li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-6">
                <div class="aa-myaccount-login">
                <h4><fmt:message key="Sign in" bundle="${BundleContent}"/></h4>
                <form class="aa-login-form" action="CheckLogin" method="post">
                  <label for=""><fmt:message key="Email address" bundle="${BundleContent}"/><span>*</span></label>
                   <input type="text" placeholder="<fmt:message key="Email address" bundle="${BundleContent}"/>">
                   <label for=""><fmt:message key="Password" bundle="${BundleContent}"/><span>*</span></label>
                    <input type="password" placeholder="<fmt:message key="Password" bundle="${BundleContent}"/>">
                    
                     <input type="hidden" name="PageLanguage" value="${Pagelanguage}"/>
                    <input type="hidden" name="PageCurrency" value="<%= request.getAttribute("PageCurrency")%>"/>
                    
                    <button type="submit" class="aa-browse-btn"><fmt:message key="Sign in" bundle="${BundleContent}" /></button>
                    <label class="rememberme" for="rememberme">	<input type="checkbox" id="rememberme" name="RememberMeCheck" value="Checked"><fmt:message key="Remember me" bundle="${BundleContent}" /></label>
                    <p class="aa-lost-password"><a href="#"><fmt:message key="Lost your password?" bundle="${BundleContent}" /></a></p>
                    
                  </form>
                  <%
							if (request.getAttribute("error") != null) {
						%>
						<%=request.getAttribute("error")%><br />
						<%
							}
						%>
						<%
							if (request.getAttribute("ok") != null) {
						%>
						<%=request.getAttribute("ok")%><br />
						<%
							}
						%>
                </div>
              </div>
              <div class="col-md-6">
                <div class="aa-myaccount-register">                 
                 <h4><fmt:message key="Register User" bundle="${BundleContent}"/></h4>
                 <form action="RegisterUser" method="POST" class="aa-login-form">
                    <label for=""><fmt:message key="Email address" bundle="${BundleContent}"/><span>*</span></label>
                    <input type="text" name="emailAddress" placeholder=<fmt:message key="Username or Email address" bundle="${BundleContent}"/> required>
                    <label for=""><fmt:message key="Password" bundle="${BundleContent}"/><span>*</span></label>
                    <input type="password" name="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required  placeholder=<fmt:message key="Password" bundle="${BundleContent}"/> required>
                    <input type="hidden" name="PageLanguage" value="${Pagelanguage}"/>
                    <input type="hidden" name="PageCurrency" value="<%= request.getAttribute("PageCurrency")%>"/>
                     <script>
                         var myInput = document.getElementById("psw");
                         var letter = document.getElementById("letter");
                         var capital = document.getElementById("capital");
                         var number = document.getElementById("number");
                         var length = document.getElementById("length");

                         // When the user clicks on the password field, show the message box
                         myInput.onfocus = function() {
                             document.getElementById("message").style.display = "block";
                         }

                         // When the user clicks outside of the password field, hide the message box
                         myInput.onblur = function() {
                             document.getElementById("message").style.display = "none";
                         }

                         // When the user starts to type something inside the password field
                         myInput.onkeyup = function() {
                             // Validate lowercase letters
                             var lowerCaseLetters = /[a-z]/g;
                             if(myInput.value.match(lowerCaseLetters)) {
                                 letter.classList.remove("invalid");
                                 letter.classList.add("valid");
                             } else {
                                 letter.classList.remove("valid");
                                 letter.classList.add("invalid");
                             }

                             // Validate capital letters
                             var upperCaseLetters = /[A-Z]/g;
                             if(myInput.value.match(upperCaseLetters)) {
                                 capital.classList.remove("invalid");
                                 capital.classList.add("valid");
                             } else {
                                 capital.classList.remove("valid");
                                 capital.classList.add("invalid");
                             }

                             // Validate numbers
                             var numbers = /[0-9]/g;
                             if(myInput.value.match(numbers)) {
                                 number.classList.remove("invalid");
                                 number.classList.add("valid");
                             } else {
                                 number.classList.remove("valid");
                                 number.classList.add("invalid");
                             }

                             // Validate length
                             if(myInput.value.length >= 8) {
                                 length.classList.remove("invalid");
                                 length.classList.add("valid");
                             } else {
                                 length.classList.remove("valid");
                                 length.classList.add("invalid");
                             }
                         }
                     </script>
                    <button type="submit" class="aa-browse-btn"><fmt:message key="Register" bundle="${BundleContent}"/></button>                    
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
 <!-- / Cart view section -->

  <!-- footer -->
	<footer id="aa-footer">
		<!-- footer bottom -->
		<%-- <jsp:include page="Inc/FooterMenu.jsp" /> --%>
		<!-- footer Menu -->

		<div class="aa-footer-top">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-footer-top-area">
							<div class="row">
								<div class="col-md-3 col-sm-6">
									<div class="aa-footer-widget">
										<h3>
											<fmt:message key="Main Menu" bundle="${BundleContent}" />
										</h3>
										<ul class="aa-footer-nav">
											<li><a href="#"><fmt:message key="Home"
														bundle="${BundleContent}" /></a></li>
											<li><a href="#"><fmt:message key="Our Services"
														bundle="${BundleContent}" /></a></li>
											<li><a href="#"><fmt:message key="About Us"
														bundle="${BundleContent}" /></a></li>
											<li><a href="#"><fmt:message key="Contact Us"
														bundle="${BundleContent}" /></a></li>
										</ul>
									</div>
								</div>
								<!-- footer Menu -->
								<!-- footer Knowledg -->
								<%-- <jsp:include page="Inc/FooterKnowledgBase.jsp" /> --%>
								<div class="col-md-3 col-sm-6">
									<div class="aa-footer-widget">
										<div class="aa-footer-widget">
											<h3>
												<fmt:message key="Knowledge Base" bundle="${BundleContent}" />
											</h3>
											<ul class="aa-footer-nav">

												<li><a href="#"><fmt:message key="Delivery"
															bundle="${BundleContent}" /></a></li>
												<li><a href="#"><fmt:message key="Returns"
															bundle="${BundleContent}" /></a></li>
												<li><a href="#"><fmt:message key="Services"
															bundle="${BundleContent}" /></a></li>
												<li><a href="#"><fmt:message key="Discounts"
															bundle="${BundleContent}" /></a></li>
												<li><a href="#"><fmt:message key="Special Offer"
															bundle="${BundleContent}" /></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- footer Knowledg -->

								<%-- <jsp:include page="Inc/FooterUSfulLinks.jsp" />  --%>
								<div class="col-md-3 col-sm-6">
									<div class="aa-footer-widget">
										<div class="aa-footer-widget">
											<h3>
												<fmt:message key="Shop" bundle="${BundleContent}" />
											</h3>
											<ul class="aa-footer-nav">
												<li><a href="#"><fmt:message key="Gift cards"
															bundle="${BundleContent}" /></a></li>
												<li><a href="#"><fmt:message
															key="Beauty Products blog" bundle="${BundleContent}" /></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- footer Knowledg -->
								<!-- footer Address -->
								<%-- <jsp:include page="Inc/FooterAddress.jsp" /> --%>
								<div class="col-md-3 col-sm-6">
									<div class="aa-footer-widget">
										<div class="aa-footer-widget">
											<h3>
												<fmt:message key="Contact us" bundle="${BundleContent}" />
											</h3>
											<address>
												<p>
													<fmt:message key="Yerevan" bundle="${BundleContent}" />
													,
													<fmt:message key="Armenia" bundle="${BundleContent}" />
												</p>
												<p>
													<span class="fa fa-phone"></span>+374 98 22 98 98
												</p>
												<p>
													<span class="fa fa-envelope"></span>info@BeautyProducts.am
												</p>
											</address>
											<div class="aa-footer-social">
												<a href="#"><span class="fa fa-facebook"></span></a> <a
													href="#"><span class="fa fa-twitter"></span></a> <a
													href="#"><span class="fa fa-google-plus"></span></a> <a
													href="#"><span class="fa fa-youtube"></span></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer Address -->
		<!-- footer-bottom -->
		<jsp:include page="Inc/FooterBottom.jsp" />
	</footer>
	<!-- / footer -->

	<!-- Login Modal -->
	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4><fmt:message key="Sign in" bundle="${BundleContent}" /></h4>
					
					
					<!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ LOGIN START-->
					<form class="aa-login-form" action="CheckLogin" method="get">
						<label for="">
						<fmt:message key="Email address" bundle="${BundleContent}" /><span>*</span></label> 
						<input type="text" name="emailAddress" placeholder="<fmt:message key="Email address" bundle="${BundleContent}" />"> 
							<label for="">
							<fmt:message key="Password" bundle="${BundleContent}" /><span>*</span></label> 
							<input name="Password"  type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required placeholder="<fmt:message key="Password" bundle="${BundleContent}" />">
							<input type="hidden" name="PageLanguage" value="${Pagelanguage}"/>
							<input type="hidden" name="PageCurrency" value="<%= request.getAttribute("PageCurrency")%>"/>
						
						<button class="aa-browse-btn" type="submit" ><fmt:message key="Sign in" bundle="${BundleContent}" /></button>
							
						
						<label for="rememberme" class="rememberme" >
						<input type="checkbox" id="rememberme" name="RememberMeCheck" value="Checked"><fmt:message key="Remember me" bundle="${BundleContent}" />  </label>
						
						<!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ LOGIN ENDS-->
						
						
						<p class="aa-lost-password">
							<a href="#"><fmt:message key="Lost your password?" bundle="${BundleContent}" />	</a>
						</p>
						<div class="aa-register-now">
							<fmt:message key="Don't have an account?" bundle="${BundleContent}" />
								<a href="Register?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>">
								<fmt:message key="Register" bundle="${BundleContent}" /></a>
						</div>
					</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<%--<jsp:include page="Inc/JQuerySection.jsp" />--%>
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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

</body>
</html>