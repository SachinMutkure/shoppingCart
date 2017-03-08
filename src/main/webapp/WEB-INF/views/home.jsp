<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Html5TemplatesDreamweaver.com">
<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
<link
	href="<c:url value="/resources/scripts/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/scripts/bootstrap/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/scripts/icons/general/stylesheets/general_foundicons.css"/>"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/scripts/icons/social/stylesheets/social_foundicons.css"/>"
	media="screen" rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/scripts/fontawesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/scripts/carousel/style.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/scripts/camera/css/camera.css"/>"
	rel="stylesheet" type="text/css" />
 <link href="http://fonts.googleapis.com/css?family=Syncopate" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/scripts/bootstrap/css/custom.css"/>"
	rel="stylesheet" type="text/css" />
<style type="text/css">
select, textarea, input[type="text"], .uneditable-input {
	display: inline-block;
	height: 32px;
	padding: 4px 6px;
	margin-bottom: 10px;
	font-size: 14px;
	line-height: 20px;
	color: #555;
	width: 96px;
	vertical-align: middle;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	margin-top: 4px;
	margin-left: 19px;
}

.sidebox {
	background-color: rgb(250, 250, 250);
	width: 257px;
	-webkit-box-shadow: none;
	box-shadow: none;
	padding: 18px;
	margin-top: 26px;
	margin-left: -63px;
	border: 1px solid rgb(235, 235, 235);
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border-bottom-left-radius: 5px;
	font-family: 'Open Sans', sans-serif;
	line-height: 24px;
	color: rgb(51, 51, 51);
}

.datepicker table {
	margin: 0;
	width: 69px;
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
</style>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="<c:url value="/resources/js/shopHome.js"/>" type="text/javascript"></script> 
<script type="text/javascript">
$(document).ready(function() {		
	if ("${cartMessage}" == "") { 

	} else {
		alert('${cartMessage}');
	}	
});
</script>
<%-- 
<script src="<c:url value="/resources/scripts/jquery.min.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/scripts/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/default.js"/>" type="text/javascript"></script> --%>
<%-- <script src="<c:url value="/resources/scripts/carousel/jquery.carouFredSel-6.2.0-packed.js"/>" type="text/javascript"></script><script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script><script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script> --%>
<%-- <script src="<c:url value="/resources/scripts/easing/jquery.easing.1.3.js"/>" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '35%', pagination: true });}$(function(){startCamera()});</script> -->

<!-- <script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script> -->
<!-- <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" /> -->
<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/> -->

</head>
<body id="pageBody">
	<div id="divBoxed" class="container">
		<div class="transparent-bg"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; z-index: -1; zoom: 1;"></div>
		<div class="divPanel notop nobottom">
			<div class="row-fluid">
				<div class="span12">
					<div id="divLogo" class="pull-left">
						<a id="divSiteTitle">Shopping Cart</a><br /> 
						<a id="divTagLine">Accelerating	Shop </a>
					</div>					
					
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<div class="pull-right">	
	    					User <c:out value="${pageContext.request.userPrincipal.name}" />
	    					&nbsp;|&nbsp;<a href="./logout">Logout</a></span>
    					</div>
					</c:if>
					  
					<div id="divMenuRight" class="pull-right">
						<div class="navbar">
							<button type="button"
								class="btn btn-navbar-highlight btn-large btn-primary"
								data-toggle="collapse" data-target=".nav-collapse">
								Menu <span class="icon-chevron-down icon-white"></span>
							</button>
							
							
								<div id="withLogin" class="nav-collapse collapse">
									<ul class="nav nav-pills ddmenu" >
										<sec:authorize access="hasRole('Admin') or hasRole('User')"> 
										<li class="active"><a href="./">Home</a></li>
										<li><a href="./showCart">Cart&nbsp;&nbsp;(${cartCount})</a></li>
										</sec:authorize>
										<sec:authorize access="hasRole('Admin')">
										<li><a href="./out">Out Product</a></li>
										<li><a href="./product">Add Product</a></li>
										<li><a href="./vender">Clients And Vender</a></li>
										</sec:authorize>			
									</ul>
								</div>
							
							
							<c:if test="${empty pageContext.request.userPrincipal}">
								<div id="withoutLogin" class="nav-collapse collapse">
									<ul class="nav nav-pills ddmenu">										
										<li class=""><a href="./login">User | Login </a></li>
										<li class=""><a href="./registration">User | Register</a></li>
									</ul>
								</div>
							</c:if>  
							
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="contentArea">
				<div class="divPanel notop page-content">
					<div class="row-fluid">
						<div class="row-fluid">
							<!--Edit Main Content Area here-->
							<div class="span8" id="divMain">
								<div class="nav-collapse collapse">
									<ul class="nav nav-pills ddmenu">
										<form role="form" action="addstock" method="post" id="myForm"
											class="login">
											<li>
												<div class="col-sm-12">
													<label>Choose Product Category</label>
													<div class="col-sm-6">
														<div class="form-group">
															<select name="categoryId" id="categoryId" required>
																<option selected value="0">Select Product
																	Category</option>
																<c:forEach items="${Categorylist}" var="product">
																	<option value="${product.id}" name="users">
																		<c:out value="${product.categoryName}"></c:out>
																	</option>
																</c:forEach>
															</select>
														</div>
													</div>
												</div>
											</li>
									</ul>
								</div>
								</form>
							</div>
							<br>
							<!-- <h3>Product List</h3> -->	
							</div>						
							<table class="tg">
								<tr>
									<th width="400">Product Name</th>
									<th width="50">Image</th>
									<th width="300">Price</th>
									<th width="300">Instock</th>
									<th width="200"></th>
									<th width="200"></th>
								</tr>
								<tr><tbody id="tablediv"></tbody>
   								</tr> 
									<%-- <c:forEach items="${Productlist}" var="product">
										<tr height="50">
											<td align="center">${product.productName}</td>
											<td align="center"><img
												src="<c:url value='/resources/images/${product.imageName}.jpg'/>"width="50" /></td>
											<td align="center">Rs.&nbsp;&nbsp;${product.productPrice}&nbsp;
												Only</td>
											<td align="center">${product.productQuantity}</td>
											<td align="center">	<a href="<c:url value='/edit/${product.id}' />">
												<button>Order Now</button></a>											</td>
											<td align="center"><a
												href="<c:url value='/addToCart/${product.id}' />"><button>AddToCart</button></a></td>
										</tr>
									</c:forEach> --%>
								</table>
							<%-- </c:if> --%>
						</div>
						
						<!-- <div id="tablediv"></div>  --> 
						<div id="footerInnerSeparator"></div>
					</div>
				</div>
</body>
</html>