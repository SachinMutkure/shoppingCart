<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>${headerMessage}</h1>
		<h1>STUDENT ADMISSION FORM FOR ENGINEERING COUNRSES</h1>
		<form action="admissionForm" method="post">
		<table>
			<tr>
				<td>Student's Name : </td><td><input type="text" name="studentName"/></td>			
			</tr>
	
			<tr>
				<td>Student's Hobby :</td><td> <input type="text" name="hobbyName"/></td>			
			</tr>
			
			<tr>
				<td>Student's Mobile :</td><td> <input type="text" name="studentMobile"/></td>			
			</tr>
			
			<tr>
				<td>Student's DOB :</td> <td><input type="text" name="studentDOB"/>yyyy-mm-dd</td>			
			</tr>
			
			<tr>
				<td>Student's Skills :</td><td> <select name="studentSkills" multiple>
													<option value="Core Java">Core Java</option>
													<option value="Core Spring">Core Spring</option>
													<option value="Spring MVC">Spring MVC</option>
												</select>
											</td>			
			</tr>
			</table>		
			<input type="submit" value="Click Here to Submit the form">
		</form>
</body>
</html>