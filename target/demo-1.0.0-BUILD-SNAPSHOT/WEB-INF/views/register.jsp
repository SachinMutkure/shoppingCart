<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/family=Open+Sans:400,700"/>" rel='stylesheet' type='text/css'>
	<link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel='stylesheet'>
    <link href="<c:url value="/resources/css/normalize.css"/>" rel='stylesheet'>
   
       <style>
      body {
  font-family: "Open Sans", sans-serif;
  height: 100vh;
    background: url("${pageContext.request.contextPath}/resources/images/black.jpg") 50% fixed;
  background-size: cover;
}

@keyframes spinner {
  0% {
    transform: rotateZ(0deg);    
  }
  100% {
    transform: rotateZ(359deg);
  }
}
* {
  box-sizing: border-box;
}

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
/*   background: rgba(4, 40, 68, 0.85); */
}

.login {
  border-radius: 2px 2px 5px 5px;
  padding: 10px 20px 20px 20px;
  width: 90%;
  max-width: 320px;
  background: #ffffff;
  position: relative;
  padding-bottom: 80px;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3);
}
.login.loading button {
  max-height: 100%;
  padding-top: 50px;
}
.login.loading button .spinner {
  opacity: 100;
  top: 40%;
}
.login.ok button {
  background-color: #8bc34a;
}
.login.ok button .spinner {
  border-radius: 0;
  border-top-color: transparent;
  border-right-color: transparent;
  height: 20px;
  animation: none;
  transform: rotateZ(-45deg);
}
.login input {
  display: block;
  padding: 15px 10px;
  margin-bottom: 10px;
  width: 100%;
  border: 1px solid #ddd;
  transition: border-width 0.2s ease;
  border-radius: 2px;
  color: #ccc;
}
.login input + i.fa {
  color: #fff;
  font-size: 1em;
  position: absolute;
  margin-top: -47px;
  opacity: 0;
  left: 0;
  transition: all 0.1s ease-in;
}
.login input:focus {
  outline: none;
  color: #444;
  border-color: #2196F3;
  border-left-width: 35px;
}
.login input:focus + i.fa {
  opacity: 1;
  left: 30px;
  transition: all 0.25s ease-out;
}
.login a {
  font-size: 0.8em;
  color: #2196F3;
  text-decoration: none;
}
.login .title {
  color: #444;
  font-size: 1.2em;
  font-weight: bold;
  margin: 10px 0 30px 0;
  border-bottom: 1px solid #eee;
  padding-bottom: 20px;
}
.login button {
  width: 100%;
  height: 100%;
  padding: 10px 10px;
  background: #2196F3;
  color: #fff;
  display: block;
  border: none;
  margin-top: 20px;
  position: absolute;
  left: 0;
  bottom: 0;
  max-height: 60px;
  border: 0px solid rgba(0, 0, 0, 0.1);
  border-radius: 0 0 2px 2px;
  transform: rotateZ(0deg);
  transition: all 0.1s ease-out;
  border-bottom-width: 7px;
}
.login button .spinner {
  display: block;
  width: 40px;
  height: 40px;
  position: absolute;
  border: 4px solid #ffffff;
  border-top-color: rgba(255, 255, 255, 0.3);
  border-radius: 100%;
  left: 50%;
  top: 0;
  opacity: 0;
  margin-left: -20px;
  margin-top: -20px;
  animation: spinner 0.6s infinite linear;
  transition: top 0.3s 0.3s ease, opacity 0.3s 0.3s ease, border-radius 0.3s ease;
  box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.2);
}
.login:not(.loading) button:hover {
  box-shadow: 0px 1px 3px #2196F3;
}
.login:not(.loading) button:focus {
  border-bottom-width: 4px;
}

footer {
  display: block;
  padding-top: 50px;
  text-align: center;
  color: #ddd;
  font-weight: normal;
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.2);
  font-size: 0.8em;
}
footer a, footer a:link {
  color: #fff;
  text-decoration: none;
}
 </style>
      <script src="<c:url value="/resources/js/prefixfree.min.js"/>"></script>
</head>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
	$(document).ready(function(){		
		message = "${message}";
	    if(message==""){ 
	    	
	    }else{
	    	alert(message);
	    }   
	})
</script>
<body>
   	<div class="wrapper">
	<form role="form" action="./addUser" method="post" id="myForm" class="login" commandName = "register" >
    <p align="center" class="title">Register</p>
	<input type="text" name="firstName"  style="text-transform: capitalize;"  placeholder="First Name" autofocus required/>
	<span class="input-group-addon"></span>
	<input type="text" name="middleName"  style="text-transform: capitalize;" placeholder="Middle Name" autofocus required/>
	<span class="input-group-addon"></span>
    <input type="text" name="lastName"  style="text-transform: capitalize;" placeholder="Last Name" autofocus required/>
	<span class="input-group-addon"></span>
	<input type="email" name="emailId"  style="text-transform: capitalize;" placeholder="Email" autofocus required/>
	<span class="input-group-addon"></span>
    <input type="text" name="mobileNo"  style="text-transform: capitalize;" placeholder="Mobile No" autofocus required/> 
    <span class="input-group-addon"></span>
    <i class="fa fa-user"></i>
    <input type="password" name="password"  placeholder="Password" required />    
    	<a align ="right" href="./login" ><h3>Already User Click Hear To Sign In</h3></a>
    <button>
      <span class="state">Sign Up</span>
    </button>
  </form>
</div>

</body>
</html>