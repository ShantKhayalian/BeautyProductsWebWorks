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
							<div class="aa-header-top-left"></div>

							<div class="aa-currency"></div>

							<!-- / currency -->
							<!-- start cellphone -->
							<jsp:include page="Inc/HeadPhone.jsp" />
							<!-- / cellphone -->
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

							<div class="aa-logo">
								<!-- Text based logo -->
								<a
									href="BP?language=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>">
									<span class="fa fa-shopping-cart"></span>
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

							<!-- search box -->
							<%-- <jsp:include page="Inc/SearchBox.jsp" /> --%>
							<div class="aa-search-box"></div>

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
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
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
										</ul></li>
								</ul></li>
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
													<li class="disabled"><a class="disabled" href="#">Disabled
															item</a></li>
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
												</ul></li>
										</ul></li>
								</ul></li>
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
										</ul></li>
								</ul></li>
							<li><a href="#">Sports</a></li>
							<li><a href="#">Digital <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Camera</a></li>
									<li><a href="#">Mobile</a></li>
									<li><a href="#">Tablet</a></li>
									<li><a href="#">Laptop</a></li>
									<li><a href="#">Accesories</a></li>
								</ul></li>
							<li><a href="#">Furniture</a></li>
							<li><a href="blog-archive.html">Blog <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="blog-archive.html">Blog Style 1</a></li>
									<li><a href="blog-archive-2.html">Blog Style 2</a></li>
									<li><a href="blog-single.html">Blog Single</a></li>
								</ul></li>
							<li><a href="contact.html">Contact</a></li>
							<li><a href="#">Pages <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="product.html">Shop Page</a></li>
									<li><a href="product-detail.html">Shop Single</a></li>
									<li><a href="404.html">404 Page</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</div>
	</section>
	<!-- / menu -->


	<!-- Registration Completed  section -->
	<section id="aa-error">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-error-area">
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
					
						
						<a
							href="BP?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"><fmt:message
								key="Go to Homepage" bundle="${BundleContent}" /> </a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Registration Completed  section -->

	<!-- Subscribe section -->
	<%-- <jsp:include page="Inc/Subscribe.jsp"/> --%>

	<section id="aa-subscribe">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-subscribe-area">
						<h3>
							<fmt:message key="Subscribe our newsletter"
								bundle="${BundleContent}" />
						</h3>
						<p>
							<fmt:message
								key="Get new products and unique gift ideas in your inbox"
								bundle="${BundleContent}" />
						</p>
						<form action="" class="aa-subscribe-form">
							<input type="email" name="" id=""
								placeholder="<fmt:message key="Enter your Email" bundle="${BundleContent}" />">
							<input type="submit"
								value="<fmt:message key="Subscribe" bundle="${BundleContent}" />">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Subscribe section -->

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
					<h4>Login or Register</h4>
					<form class="aa-login-form" action="">
						<label for="">Username or Email address<span>*</span></label> <input
							type="text" placeholder="Username or email"> <label
							for="">Password<span>*</span></label> <input type="password"
							placeholder="Password">
						<button class="aa-browse-btn" type="submit">Login</button>
						<label for="rememberme" class="rememberme"><input
							type="checkbox" id="rememberme"> Remember me </label>
						<p class="aa-lost-password">
							<a href="#">Lost your password?</a>
						</p>
						<div class="aa-register-now">
							Don't have an account?<a href="account.html">Register now!</a>
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