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
<link href="http://fonts.googleapis.com/css?family=Syncopate"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Abel"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Pontano+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Oxygen"
	rel="stylesheet" type="text/css">
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
<script type="text/javascript">
$( document ).ready(function() {
	
	  
    $('#categoryid').on('change', function() {      	
        categoryid = $('#categoryid').val();     	
    	$.ajax({
			url : "./productlist",
			type : "GET",
			dataType:"json",
            data: {
            	categoryid : categoryid
            },
            success : function(response) {
             /* 	alert(response); */
				var tbody= '';
				var tb;
				var insertrow;
				var srno = 1;
				$.each(response, function(index, product){
					insertrow=
						/* <c:forEach items="${listPersons}" var="person">
					<tr>
						<td>${person.id}</td>
						<td>${person.name}</td>
						<td>${person.country}</td>
						<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
						<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
					</tr>
				</c:forEach> */
						  ' <tr>' +
						  '	<td>'+srno+'</td> '+
						  '	<td>'+product.productname+'</td>'+
						  '	<td><input type="text"></td>'+
						  '	<td><select  name="clientid"   required id="venderid">'+
						  '        <option selected value="0">Client</option>'+
						  '        <c:forEach items="${Clientlist}" var="client">'+
						  '           <option value="${client.clientid}" name="users">'+
						  '              <c:out value="${client.clientname}"></c:out>'+
						  '           </option>'+
						  '        </c:forEach>'+
						  '     </select>'+
						  ' </td>'+
						  '	<td><select  name="id" required id="venderid">'+
						  '        <option selected value="0">Type</option>'+
						  '        <c:forEach items="${Outtypelist}" var="outtype">'+
						  '           <option value="${outtype.id}" name="users">'+
						  '              <c:out value="${outtype.type}"></c:out>'+
						  '           </option>'+
						  '        </c:forEach>'+
						  '     </select>'+
						  ' </td>'+
						  ' <tr>'  
				
							if (tbody == '') {
								tbody = insertrow;
							} else {
								tbody = tbody + insertrow;
							}
					srno++;
				});
				
				$("#tablediv").empty().append(tbody);
				$("#tablediv").show();
			},
			error : function() {
				alert('error...');
			}
        });        
    });
});


</script>


<script type="text/javascript">
$( document ).ready(function() {
    $('#inoutid').on('click', function() { 
     	 alert("hi");  
     	inoutid = $('#inoutid').val();
     	
    	$.ajax({
			url : "./productlist",
			type : "GET",
			dataType:"json",
            data: {
            	categoryid : categoryid
            },
            success : function(response) {
              	alert(response); 
				var tbody= '';
				var tb;
				var insertrow;
				var srno = 1;
				$.each(response, function(index, product){
					insertrow=
						  ' <tr>' +
						  '	<td>'+srno+'</td> '+
						  '	<td>'+product.productname+'</td>'+
						  '	<td><input type="text"></td>'+
						  '	<td><select  name="clientid"   required id="venderid"><option selected value="0">Client</option><c:forEach items="${Clientlist}" var="client"><option value="${client.clientid}" name="users"><c:out value="${client.clientname}"></c:out></option></c:forEach></select></td>'+
						  '	<td><select  name="id" required id="venderid"><option selected value="0">Type</option><c:forEach items="${Outtypelist}" var="outtype"><option value="${outtype.id}" name="users"><c:out value="${outtype.type}"></c:out></option></c:forEach></select></td>'+
						  ' <tr>'
						  
				
							if (tbody == '') {
								tbody = insertrow;
							} else {
								tbody = tbody + insertrow;
							}
					srno++;
				});
				
				$("#tablediv").empty().append(tbody);
				$("#tablediv").show();
			},
			error : function() {
				alert('error...');
			}
        });
        
    });
});
</script>

<script src="<c:url value="/resources/scripts/jquery.min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/scripts/bootstrap/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/scripts/default.js"/>"
	type="text/javascript"></script>
<%-- <script src="<c:url value="/resources/scripts/carousel/jquery.carouFredSel-6.2.0-packed.js"/>" type="text/javascript"></script><script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script><script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script> --%>
<script
	src="<c:url value="/resources/scripts/easing/jquery.easing.1.3.js"/>"
	type="text/javascript"></script>
<!-- <script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '35%', pagination: true });}$(function(){startCamera()});</script> -->

<script type="text/javascript"
	src="https://formden.com/static/cdn/formden.js"></script>
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/> -->

<script>
	$(document).ready(function(){
		if("${message}"== ""){
			
		}else{
			alert("${message}");
		}
	})
	
	function changeFunc(sr,productPrice,dropValue){   				
		var textValue1 = $( "#" + dropValue +" option:selected" ).text();		   
	    price = textValue1 * productPrice;  
	    var estimatedPrice = parseInt($('#estimatePrice').val());
	    var first = parseInt(productPrice);	    
	    var sumofPrice = estimatedPrice + ((productPrice * $( "#" + dropValue +" option:selected" ).val()) -  $("#" + sr).val());	    
	    $("#" + sr).val(price);
	    $("#estimatePrice").val(sumofPrice);   	     
	}
	
	function removeCart(cartId){
		window.location = "./removeCart?id="+cartId; 
	}
</script>
</head>
<body id="pageBody">
	<div id="divBoxed" class="container">
		<div class="transparent-bg"
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; z-index: -1; zoom: 1;"></div>
		<div class="divPanel notop nobottom">
			<div class="row-fluid">
				<div class="span12">
					<div id="divLogo" class="pull-left">
						<a id="divSiteTitle">Shopping Cart</a><br /> <a id="divTagLine">Accelerating
							Shop </a>
					</div>
					<%-- <div class ="pull-right"><span id ="usrdiv"> <u> Welcome</u>&nbsp;&nbsp;${username}&nbsp;|&nbsp;<a href="./logout">Logout</a></span></div> --%>
					<div id="divMenuRight" class="pull-right">
						<div class="navbar">
							<button type="button"
								class="btn btn-navbar-highlight btn-large btn-primary"
								data-toggle="collapse" data-target=".nav-collapse">
								Menu <span class="icon-chevron-down icon-white"></span>
							</button>
							<div id="withLogin" class="nav-collapse collapse">
								<ul class="nav nav-pills ddmenu">
									<li><a href="./">Home</a></li>
									<li><a href="./out">Out Product</a></li>
									<li><a href="./product">Add Product</a></li>
									<li><a href="./vender">Clients And Vender</a></li>
									<li class="active"><a href="">Cart</a></li>
								</ul>
							</div>
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
										<!-- <form role="form" action="addstock" method="post" id="myForm"
											class="login"> -->

											<li><c:if test="${!empty productList}">
													<table class="tg">
														<tr>
															<th width="500">Calculate Price :</th>
															<!-- <th width="500">Price/Unit (Rs.)</th> -->
															<th width="500">Image</th>
															<th width="500">Select Qty.</th>
															<th width="500">Action</th> 
														</tr>

														<c:set var="srNo" value="${0}" />
														<c:set var="dropValue" value="${1000}" />
														<c:set var="productPrice" value="${0}" />
														<c:forEach items="${productList}" var="product">
															<c:set var="srNo" value="${srNo + 1}" />
															<c:set var="dropValue" value="${dropValue + 1}" />
															<c:set var="productPrice"
																value="${productPrice + product.productPrice}" /> 
															<tr>
																<td><label>Product Price:</label> <input 
																	type="text" name="productName" id="${srNo}"
																	value="${product.productPrice}" readonly />Only</td>

																<td><img
																	src="<c:url value='/resources/images/${product.imageName}.jpg'/>"
																	width="50" /><br> <label><h4>${product.productName}</h4></label>
																	<span id="price">Rs.&nbsp;${product.productPrice}</span>&nbsp;Only
																</td>

																<td><br> Qty. <select id="${dropValue}"
																	onchange="changeFunc(${srNo},${product.productPrice},${dropValue});">
																		<option value="1" selected>1</option>
																		<option value="2">2</option>
																		<option value="3">3</option>
																		<option value="4">4</option>
																		<option value="5">5</option>
																</select></td>
																
																<td>
																	<button id="update-btn" onclick="removeCart(${product.id});">Cancel</button> 
																</td>

															</tr>
														</c:forEach>
													</table>
												</c:if></li>
												
									</ul>
								</div>
								<!-- </form> --> 
								
							</div>
							<br>

						</div>
						<div id="footerInnerSeparator"></div>
					</div>
				</div>  
				 <hr> <label><b>Estimated Price: &nbsp;</b></label>     
				Rs.<input type="text" name="estimatePrice" id="estimatePrice"	value="${productPrice}" readonly />Only
</body>
</html>