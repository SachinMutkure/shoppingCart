<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- Internationalization and Localization-->
		<a href="/demo/welcomeReg?siteLanguage=en">English</a> | <a href="/demo/welcomeReg?siteLanguage=fr">French</a>
		
		<h1><spring:message code="label.headerMessage"/></h1>
		<h3><spring:message code="label.admissionForm"/></h3>
		<font color="red"><form:errors path="student1.*"/></font>		
		<form:form commandName="student1" action="registrationsubmit" method="post" >
		<table>
			<tr>  <td><spring:message code="label.studentName"/>:  </td> <td> <input type="text" name="studentName"/>         </td> </tr>	
			<tr>  <td><spring:message code="label.studentHobby"/>: </td> <td> <input type="text" name="hobbyName"/>           </td> </tr>			
			<tr>  <td><spring:message code="label.studentMobile"/>:</td> <td> <input type="text" name="studentMobile"/>       </td> </tr>			
			<tr>  <td><spring:message code="label.studentDOB"/>:   </td> <td> <input type="text" name="studentDOB"/>yyyy-mm-dd</td> </tr>
						
			<tr>  <td><spring:message code="label.studentSkills"/>:</td> <td> <select name="studentSkills" multiple> 
														<option value="Core Java">Core Java</option>
														<option value="Core Spring">Core Spring</option>
														<option value="Spring MVC">Spring MVC</option>
												   </select>
											  </td>			
			</tr>
			</table>	
			<table>
				<tr><td><spring:message code="label.studentAddress"/>: </td></tr>
				<tr><td><spring:message code="label.country"/>: <input type="text" name="studentAddress.country"/></td>
					<td><spring:message code="label.city"/>:    <input type="text" name="studentAddress.city"/>   </td>
					<td><spring:message code="label.street"/>:  <input type="text" name="studentAddress.street"/> </td>
					<td><spring:message code="label.pincode"/>: <input type="text" name="studentAddress.pincode"/></td>
				</tr>			
			</table>
				
			<input type="submit" value="<spring:message code="label.submit.admissionForm"/>">
		</form:form>
</body>
</html>