<%@ page language="java" contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <%--<jsp:include page="Inc/Header.jsp" />--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>BP | User Admin</title>

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
    <!-- <link id="switcher" href="<%=request.getContextPath()%>/css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
    <link href="<%=request.getContextPath()%>/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" >
    <link href="<%=request.getContextPath()%>/css/accordion.css" rel="stylesheet" media="all">


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
<body>
<fmt:setLocale value="${Pagelanguage}"/>
<fmt:setBundle var="BundleContent" basename="BeautyIt.BP.Resources.Content"/>
<!-- wpf loader Two -->
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span><fmt:message key="Loading" bundle="${BundleContent}"/></span>
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

                            <jsp:include page="../Inc/HeadPhone.jsp"/>
                            <!-- / cellphone -->
                        </div>
                        <!-- / header top left -->
                        <%-- <jsp:include page="Inc/AccountSection.jsp" /> --%>
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <%-- <li><a href="#"><fmt:message key="SonBP"
                                                              bundle="${BundleContent}" /></a></li>
                                 <li class="hidden-xs">
                                     <a href="Register?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"><fmt:message
                                             key="Register" bundle="${BundleContent}" /></a></li>--%>
                                    <li>  <span class="fa fa-user"><%=request.getAttribute("userEmail")%></span> </li>
                                  <%--  <li><a href="" data-toggle="modal"><fmt:message key="My Account" bundle="${BundleContent}"/></a></li>--%>


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
                            <a href="BP?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>">
                                <span class="fa fa-shopping-cart"></span>
                                <p>
                                    BP <strong><fmt:message key="Stores"
                                                            bundle="${BundleContent}"/></strong> <span><fmt:message
                                        key="Your Shopping Partner" bundle="${BundleContent}"/></span>
                                </p>
                            </a>
                            <!-- img based logo -->
                            <!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
                        </div>
                        <!-- / logo  -->
                      <%--  <!-- cart box -->
                        <jsp:include page="../Inc/CartBox.jsp"/>
                        <!-- / cart box -->--%>
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
        </div>
    </div>
</section>
<!-- / menu -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="<%=request.getContextPath()%>/img/advertisinginuserpage/Celebrate-Web-banner-top-1920x300.jpg" alt="Advertising img">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Kesab Tour</h2>
                <ol class="breadcrumb">
                    <li><a href="index.html">Check the store</a></li>
                    <li class="active">Natural Cosmetics</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- product category -->
<section id="aa-product-category">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
                <div class="aa-product-catg-content">
                    <div class="aa-product-catg-head">
                        <div class="aa-product-catg-head-left">
                            <form action="" class="aa-sort-form">
                                <label for=""><fmt:message key="Contact us" bundle="${BundleContent}"/></label>
                                <select name="">
                                    <option value="1" selected="<fmt:message key="Contact Us" bundle="${BundleContent}"/>"><fmt:message key="Contact Us" bundle="${BundleContent}"/></option>
                                    <option value="2"><fmt:message key="Support" bundle="${BundleContent}"/> |
                                        <fmt:message key="If you have any question" bundle="${BundleContent}"/></option>
                                    <option value="3"><fmt:message key="Orders" bundle="${BundleContent}"/> |
                                        <fmt:message key="If you have problem with your order"
                                                     bundle="${BundleContent}"/></option>

                                </select>
                            </form>
                            <%-- <form action="" class="aa-show-form">
                                 <label for="">Show</label>
                                 <select name="">
                                     <option value="1" selected="12">12</option>
                                     <option value="2">24</option>
                                     <option value="3">36</option>
                                 </select>
                             </form>--%>
                        </div>
                        <div class="aa-product-catg-head-right">
                            <%--  <a id="grid-catg" href="#"><span class="fa fa-th"></span></a>
                              <a id="list-catg" href="#"><span class="fa fa-list"></span></a>--%>
                        </div>
                    </div>
                    <div class="aa-product-catg-body">

                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Compose New Message</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="To:">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Subject:">
                                    </div>
                                    <div class="form-group">
                    <textarea id="compose-textarea" class="form-control" style="height: 300px">
                      <h1><u>Heading Of Message</u></h1>
                      <h4>Subheading</h4>
                      <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain
                        was born and I will give you a complete account of the system, and expound the actual teachings
                        of the great explorer of the truth, the master-builder of human happiness. No one rejects,
                        dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know
                        how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again
                        is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain,
                        but because occasionally circumstances occur in which toil and pain can procure him some great
                        pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise,
                        except to obtain some advantage from it? But who has any right to find fault with a man who
                        chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that
                        produces no resultant pleasure? On the other hand, we denounce with righteous indignation and
                        dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so
                        blinded by desire, that they cannot foresee</p>
                      <ul>
                        <li>List item one</li>
                        <li>List item two</li>
                        <li>List item three</li>
                        <li>List item four</li>
                      </ul>
                      <p>Thank you,</p>
                      <p>John Doe</p>
                    </textarea>
                                    </div>
                                    <div class="form-group">
                                       <%-- <div class="btn btn-default btn-file">
                                            <i class="fa fa-paperclip"></i> Attachment
                                            <input type="file" name="attachment">
                                        </div>
                                        <p class="help-block">Max. 32MB</p>--%>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                                <div class="box-footer">
                                    <div class="pull-right">
                                        <button type="button" class="btn btn-default"><i class="fa fa-pencil"></i> Draft</button>
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Send</button>
                                    </div>
                                    <button type="reset" class="btn btn-default"><i class="fa fa-times"></i> Discard</button>
                                </div>
                                <!-- /.box-footer -->
                            </div>
                            <!-- /. box -->

                    </div>
                    <div class="aa-product-catg-pagination">
                        <%-- <nav>
                             <ul class="pagination">
                                 <li>
                                     <a href="#" aria-label="Previous">
                                         <span aria-hidden="true">&laquo;</span>
                                     </a>
                                 </li>
                                 <li><a href="#">1</a></li>
                                 <li><a href="#">2</a></li>
                                 <li><a href="#">3</a></li>
                                 <li><a href="#">4</a></li>
                                 <li><a href="#">5</a></li>
                                 <li>
                                     <a href="#" aria-label="Next">
                                         <span aria-hidden="true">&raquo;</span>
                                     </a>
                                 </li>
                             </ul>
                         </nav>--%>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                <aside class="aa-sidebar">

                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">

                        <h3><fmt:message key="Users Section" bundle="${BundleContent}"/>
                            <br>
                        </h3>
                        <button class="accordion"><fmt:message key="Profile" bundle="${BundleContent}"/> <i
                                class="fa fa-user"></i></button>

                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="Update Profile" bundle="${BundleContent}"/> <i
                                        class="fa fa-wrench"></i></a></li>
                                <li><a href=""><fmt:message key="Change password" bundle="${BundleContent}"/> <i
                                        class="fa fa-unlock-alt"></i></a></li>
                                <li><a href=""><fmt:message key="Add Picture" bundle="${BundleContent}"/> <i
                                        class="fa fa-image"></i></a></li>
                            </ul>
                        </div>


                        <button class="accordion"><fmt:message key="Verifications" bundle="${BundleContent}"/> <i
                                class="fa fa-book"></i></button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="Email verification" bundle="${BundleContent}"/> <i
                                        class="fa fa-check-circle"></i></a></li>
                                <li><a href=""><fmt:message key="Phone verification" bundle="${BundleContent}"/> <i
                                        class="fa fa-circle-o"></i></a></li>
                                <li><a href=""><fmt:message key="Address verification" bundle="${BundleContent}"/> <i
                                        class="fa fa-circle-o"></i></a></li>
                            </ul>
                        </div>

                        <button class="accordion"><fmt:message key="Orders" bundle="${BundleContent}"/> <i
                                class="fa fa-product-hunt" aria-hidden="true"></i></button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="New Orders" bundle="${BundleContent}"/> <i
                                        class="fa fa fa-plus-circle"></i></a></li>
                                <li><a href=""><fmt:message key="Shipped Orders" bundle="${BundleContent}"/> <i
                                        class="fa fa fa-truck"></i></a></li>
                                <li><a href=""><fmt:message key="Received orders" bundle="${BundleContent}"/> <i
                                        class="fa fa-archive"></i></a></li>
                                <li><a href=""><fmt:message key="History" bundle="${BundleContent}"/> <i
                                        class="fa fa-history"></i></a></li>
                                <li><a href=""><fmt:message key="Returned" bundle="${BundleContent}"/> <i
                                        class="fa fa-exchange"></i></a></li>
                                <li><a href=""><fmt:message key="Invoice" bundle="${BundleContent}"/> <i
                                        class="fa fa-file-text"></i></a></li>
                            </ul>
                        </div>

                        <button class="accordion"><fmt:message key="Favorites" bundle="${BundleContent}"/> <i
                                class="fa fa-heartbeat"></i></button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="Wish list" bundle="${BundleContent}"/> <i
                                        class="fa fa-heart"></i></a></li>
                                <li><a href="#"> <fmt:message key="Products" bundle="${BundleContent}"/> <i
                                        class="fa fa-anchor"></i></a></li>
                                <li><a href="#"><fmt:message key="Sellers" bundle="${BundleContent}"/> <i
                                        class="fa fa-diamond"></i></a></li>


                            </ul>
                        </div>

                        <button class="accordion"><fmt:message key="Mailbox" bundle="${BundleContent}"/> <i
                                class="fa fa-envelope"></i>

                        </button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li>
                                    <a href="ReadUserEmail?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"><fmt:message
                                            key="Inbox" bundle="${BundleContent}"/> <i class="fa fa-envelope"></i>
                                        <span class="pull-right-container">
                                <span class="label label-primary pull-right"><%=request.getAttribute("CountMessages")%>
                                </span>
                                    </a>
                                </li>
                                <a href="Compose?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>"><fmt:message
                                        key="Compose" bundle="${BundleContent}"/><i class="fa fa-send-o"></i></a>
                                <li><a href="#"><fmt:message key="Contacts Book" bundle="${BundleContent}"/> <i
                                        class="fa fa-book"></i></a></li>

                            </ul>
                        </div>

                        <button class="accordion"><fmt:message key="Gift cards" bundle="${BundleContent}"/> <i
                                class="fa fa-gift"></i></button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="Gift cards" bundle="${BundleContent}"/> <i
                                        class="fa fa-gift"></i></a></li>
                                <li><a href="#"><fmt:message key="Gift cards" bundle="${BundleContent}"/> <i
                                        class="fa fa-gift"></i></a></li>
                                <li><a href="#"><fmt:message key="Gift cards" bundle="${BundleContent}"/> <i
                                        class="fa fa-gift"></i></a></li>
                                <li><a href="#"><fmt:message key="Gift cards" bundle="${BundleContent}"/> <i
                                        class="fa fa-gift"></i></a></li>

                            </ul>
                        </div>

                        <button class="accordion"><fmt:message key="Become seller" bundle="${BundleContent}"/> <i
                                class="fa fa-signal"></i></button>
                        <div class="panel">
                            <ul class="aa-catg-nav">
                                <li><a href="#"><fmt:message key="Become seller" bundle="${BundleContent}"/> <i
                                        class="fa fa-signal"></i></a></li>
                            </ul>
                        </div>


                    </div>
                    <!-- single sidebar -->
                    <%-- <div class="aa-sidebar-widget">
                         <h3>Tags</h3>
                         <div class="tag-cloud">
                             <a href="#">Fashion</a>
                             <a href="#">Ecommerce</a>
                             <a href="#">Shop</a>
                             <a href="#">Hand Bag</a>
                             <a href="#">Laptop</a>
                             <a href="#">Head Phone</a>
                             <a href="#">Pen Drive</a>
                         </div>
                     </div>--%>
                    <!-- single sidebar -->
                    <%--                    <div class="aa-sidebar-widget">
                                            <h3>Shop By Price</h3>
                                            <!-- price range -->
                                            <div class="aa-sidebar-price-range">
                                                <form action="">
                                                    <div id="skipstep" class="noUi-target noUi-ltr noUi-horizontal noUi-background">
                                                    </div>
                                                    <span id="skip-value-lower" class="example-val">30.00</span>
                                                    <span id="skip-value-upper" class="example-val">100.00</span>
                                                    <button class="aa-filter-btn" type="submit">Filter</button>
                                                </form>
                                            </div>

                                        </div>--%>
                    <!-- single sidebar -->
                    <%-- <div class="aa-sidebar-widget">
                         <h3>Shop By Color</h3>
                         <div class="aa-color-tag">
                             <a class="aa-color-green" href="#"></a>
                             <a class="aa-color-yellow" href="#"></a>
                             <a class="aa-color-pink" href="#"></a>
                             <a class="aa-color-purple" href="#"></a>
                             <a class="aa-color-blue" href="#"></a>
                             <a class="aa-color-orange" href="#"></a>
                             <a class="aa-color-gray" href="#"></a>
                             <a class="aa-color-black" href="#"></a>
                             <a class="aa-color-white" href="#"></a>
                             <a class="aa-color-cyan" href="#"></a>
                             <a class="aa-color-olive" href="#"></a>
                             <a class="aa-color-orchid" href="#"></a>
                         </div>
                     </div>--%>
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3>Recently Views</h3>
                        <div class="aa-recently-views">
                            <ul>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-2.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-1.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-2.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3>Top Rated Products</h3>
                        <div class="aa-recently-views">
                            <ul>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-2.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-1.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                                <li>
                                    <a href="#" class="aa-cartbox-img"><img alt="img" src="img/woman-small-2.jpg"></a>
                                    <div class="aa-cartbox-info">
                                        <h4><a href="#">Product Name</a></h4>
                                        <p>1 x $250</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </aside>
            </div>

        </div>
    </div>
</section>
<!-- / product category -->
<!-- Support section -->
<section id="aa-support">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-support-area">
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-truck"></span>
                            <h4>FREE SHIPPING</h4>
                            <P>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                Quam, nobis.</P>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-clock-o"></span>
                            <h4>30 DAYS MONEY BACK</h4>
                            <P>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                Quam, nobis.</P>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-phone"></span>
                            <h4>SUPPORT 24/7</h4>
                            <P>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                Quam, nobis.</P>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Support section -->
<!-- Testimonial -->
<section id="aa-testimonial">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-testimonial-area">
                    <ul class="aa-testimonial-slider">
                        <!-- single slide -->
                        <li>
                            <div class="aa-testimonial-single">
                                <img class="aa-testimonial-img" src="../img/testimonial-img-2.jpg"
                                     alt="testimonial img"> <span
                                    class="fa fa-quote-left aa-testimonial-quote"></span>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Sunt distinctio omnis possimus, facere, quidem
                                    qui!consectetur adipisicing elit. Sunt distinctio omnis
                                    possimus, facere, quidem qui.</p>
                                <div class="aa-testimonial-info">
                                    <p>Allison</p>
                                    <span>Designer</span> <a href="#">Dribble.com</a>
                                </div>
                            </div>
                        </li>
                        <!-- single slide -->
                        <li>
                            <div class="aa-testimonial-single">
                                <img class="aa-testimonial-img" src="../img/testimonial-img-1.jpg"
                                     alt="testimonial img"> <span
                                    class="fa fa-quote-left aa-testimonial-quote"></span>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Sunt distinctio omnis possimus, facere, quidem
                                    qui!consectetur adipisicing elit. Sunt distinctio omnis
                                    possimus, facere, quidem qui.</p>
                                <div class="aa-testimonial-info">
                                    <p>KEVIN MEYER</p>
                                    <span>CEO</span> <a href="#">Alphabet</a>
                                </div>
                            </div>
                        </li>
                        <!-- single slide -->
                        <li>
                            <div class="aa-testimonial-single">
                                <img class="aa-testimonial-img" src="../img/testimonial-img-3.jpg"
                                     alt="testimonial img"> <span
                                    class="fa fa-quote-left aa-testimonial-quote"></span>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Sunt distinctio omnis possimus, facere, quidem
                                    qui!consectetur adipisicing elit. Sunt distinctio omnis
                                    possimus, facere, quidem qui.</p>
                                <div class="aa-testimonial-info">
                                    <p>Luner</p>
                                    <span>COO</span> <a href="#">Kinatic Solution</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Testimonial -->

<!-- Latest Blog -->
<section id="aa-latest-blog">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-latest-blog-area">
                    <h2>LATEST BLOG</h2>
                    <div class="row">
                        <!-- single latest blog -->
                        <div class="col-md-4 col-sm-4">
                            <div class="aa-latest-blog-single">
                                <figure class="aa-blog-img">
                                    <a href="#"><img src="../img/promo-banner-1.jpg" alt="img"></a>
                                    <figcaption class="aa-blog-img-caption">
                                        <span href="#"><i class="fa fa-eye"></i>5K</span> <a href="#"><i
                                            class="fa fa-thumbs-o-up"></i>426</a> <a href="#"><i
                                            class="fa fa-comment-o"></i>20</a> <span href="#"><i
                                            class="fa fa-clock-o"></i>June 26, 2016</span>
                                    </figcaption>
                                </figure>
                                <div class="aa-blog-info">
                                    <h3 class="aa-blog-title">
                                        <a href="#">Lorem ipsum dolor sit amet</a>
                                    </h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                        elit. Assumenda, ad? Autem quos natus nisi aperiam, beatae,
                                        fugiat odit vel impedit dicta enim repellendus animi.
                                        Expedita quas reprehenderit incidunt, voluptates corporis.</p>
                                    <a href="#" class="aa-read-mor-btn">Read more <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                            </div>
                        </div>
                        <!-- single latest blog -->
                        <div class="col-md-4 col-sm-4">
                            <div class="aa-latest-blog-single">
                                <figure class="aa-blog-img">
                                    <a href="#"><img src="../img/promo-banner-3.jpg" alt="img"></a>
                                    <figcaption class="aa-blog-img-caption">
                                        <span href="#"><i class="fa fa-eye"></i>5K</span> <a href="#"><i
                                            class="fa fa-thumbs-o-up"></i>426</a> <a href="#"><i
                                            class="fa fa-comment-o"></i>20</a> <span href="#"><i
                                            class="fa fa-clock-o"></i>June 26, 2016</span>
                                    </figcaption>
                                </figure>
                                <div class="aa-blog-info">
                                    <h3 class="aa-blog-title">
                                        <a href="#">Lorem ipsum dolor sit amet</a>
                                    </h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                        elit. Assumenda, ad? Autem quos natus nisi aperiam, beatae,
                                        fugiat odit vel impedit dicta enim repellendus animi.
                                        Expedita quas reprehenderit incidunt, voluptates corporis.</p>
                                    <a href="#" class="aa-read-mor-btn">Read more <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                            </div>
                        </div>
                        <!-- single latest blog -->
                        <div class="col-md-4 col-sm-4">
                            <div class="aa-latest-blog-single">
                                <figure class="aa-blog-img">
                                    <a href="#"><img src="../img/promo-banner-1.jpg" alt="img"></a>
                                    <figcaption class="aa-blog-img-caption">
                                        <span href="#"><i class="fa fa-eye"></i>5K</span> <a href="#"><i
                                            class="fa fa-thumbs-o-up"></i>426</a> <a href="#"><i
                                            class="fa fa-comment-o"></i>20</a> <span href="#"><i
                                            class="fa fa-clock-o"></i>June 26, 2016</span>
                                    </figcaption>
                                </figure>
                                <div class="aa-blog-info">
                                    <h3 class="aa-blog-title">
                                        <a href="#">Lorem ipsum dolor sit amet</a>
                                    </h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                        elit. Assumenda, ad? Autem quos natus nisi aperiam, beatae,
                                        fugiat odit vel impedit dicta enim repellendus animi.
                                        Expedita quas reprehenderit incidunt, voluptates corporis.</p>
                                    <a href="#" class="aa-read-mor-btn">Read more <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Latest Blog -->

<!-- Client Brand -->
<section id="aa-client-brand">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-client-brand-area">
                    <ul class="aa-client-brand-slider">
                        <li><a href="#"><img src="../img/client-brand-java.png"
                                             alt="java img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-jquery.png"
                                             alt="jquery img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-html5.png"
                                             alt="html5 img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-css3.png"
                                             alt="css3 img"></a></li>
                        <li><a href="#"><img
                                src="../img/client-brand-wordpress.png" alt="wordPress img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-joomla.png"
                                             alt="joomla img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-java.png"
                                             alt="java img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-jquery.png"
                                             alt="jquery img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-html5.png"
                                             alt="html5 img"></a></li>
                        <li><a href="#"><img src="../img/client-brand-css3.png"
                                             alt="css3 img"></a></li>
                        <li><a href="#"><img
                                src="../img/client-brand-wordpress.png" alt="wordPress img"></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Client Brand -->

<!-- Subscribe section -->
<%-- <jsp:include page="Inc/Subscribe.jsp"/> --%>

<section id="aa-subscribe">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-subscribe-area">
                    <h3>
                        <fmt:message key="Subscribe our newsletter"
                                     bundle="${BundleContent}"/>
                    </h3>
                    <p>
                        <fmt:message
                                key="Get new products and unique gift ideas in your inbox"
                                bundle="${BundleContent}"/>
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
                                        <fmt:message key="Main Menu" bundle="${BundleContent}"/>
                                    </h3>
                                    <ul class="aa-footer-nav">
                                        <li><a href="#"><fmt:message key="Home"
                                                                     bundle="${BundleContent}"/></a></li>
                                        <li><a href="#"><fmt:message key="Our Services"
                                                                     bundle="${BundleContent}"/></a></li>
                                        <li><a href="#"><fmt:message key="About Us"
                                                                     bundle="${BundleContent}"/></a></li>
                                        <li><a href="#"><fmt:message key="Contact Us"
                                                                     bundle="${BundleContent}"/></a></li>
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
                                            <fmt:message key="Knowledge Base" bundle="${BundleContent}"/>
                                        </h3>
                                        <ul class="aa-footer-nav">

                                            <li><a href="#"><fmt:message key="Delivery"
                                                                         bundle="${BundleContent}"/></a></li>
                                            <li><a href="#"><fmt:message key="Returns"
                                                                         bundle="${BundleContent}"/></a></li>
                                            <li><a href="#"><fmt:message key="Services"
                                                                         bundle="${BundleContent}"/></a></li>
                                            <li><a href="#"><fmt:message key="Discounts"
                                                                         bundle="${BundleContent}"/></a></li>
                                            <li><a href="#"><fmt:message key="Special Offer"
                                                                         bundle="${BundleContent}"/></a></li>
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
                                            <fmt:message key="Shop" bundle="${BundleContent}"/>
                                        </h3>
                                        <ul class="aa-footer-nav">
                                            <li><a href="#"><fmt:message key="Gift cards"
                                                                         bundle="${BundleContent}"/></a></li>
                                            <li><a href="#"><fmt:message
                                                    key="Beauty Products blog" bundle="${BundleContent}"/></a></li>
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
                                            <fmt:message key="Contact us" bundle="${BundleContent}"/>
                                        </h3>
                                        <address>
                                            <p>
                                                <fmt:message key="Yerevan" bundle="${BundleContent}"/>
                                                ,
                                                <fmt:message key="Armenia" bundle="${BundleContent}"/>
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
    <jsp:include page="../Inc/FooterBottom.jsp"/>
</footer>
<!-- / footer -->

<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4><fmt:message key="Sign in" bundle="${BundleContent}"/></h4>


                <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ LOGIN START-->
                <form class="aa-login-form" action="CheckLogin" method="post">
                    <label for="">
                        <fmt:message key="Email address" bundle="${BundleContent}"/><span>*</span></label>
                    <input type="text" name="emailAddress"
                           placeholder="<fmt:message key="Email address" bundle="${BundleContent}" />">
                    <label for="">
                        <fmt:message key="Password" bundle="${BundleContent}"/><span>*</span></label>
                    <input name="Password" type="password"
                           placeholder="<fmt:message key="Password" bundle="${BundleContent}" />">
                    <input type="hidden" name="PageLanguage" value="${Pagelanguage}"/>
                    <input type="hidden" name="PageCurrency" value="<%= request.getAttribute("PageCurrency")%>"/>

                    <button class="aa-browse-btn" type="submit"><fmt:message key="Sign in"
                                                                             bundle="${BundleContent}"/></button>


                    <label for="rememberme" class="rememberme">
                        <input type="checkbox" id="rememberme" name="RememberMeCheck" value="Checked"><fmt:message
                            key="Remember me" bundle="${BundleContent}"/> </label>

                    <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ LOGIN ENDS-->


                    <p class="aa-lost-password">
                        <a href="#"><fmt:message key="Lost your password?" bundle="${BundleContent}"/> </a>
                    </p>
                    <div class="aa-register-now">
                        <fmt:message key="Don't have an account?" bundle="${BundleContent}"/>
                        <a href="Register?Pagelanguage=${Pagelanguage}&PageCurrency=<%= request.getAttribute("PageCurrency")%>">
                            <fmt:message key="Register" bundle="${BundleContent}"/></a>
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
<!-- ./wrapper -->



//TODO: check the line for the error
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<%--<script src="<%=request.getContextPath()%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>--%>
<!-- Morris.js charts -->
<script src="<%=request.getContextPath()%>/bower_components/raphael/raphael.min.js"></script>
<script src="<%=request.getContextPath()%>/bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="<%=request.getContextPath()%>/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/bower_components/moment/min/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="<%=request.getContextPath()%>/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<%=request.getContextPath()%>/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="<%=request.getContextPath()%>/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<%=request.getContextPath()%>/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/dist/js/adminlte.min.js"></script>

<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
</script>
<script>
    $(function () {
        //Add text editor
        $("#compose-textarea").wysihtml5();
    });
</script>



</body>
</html>