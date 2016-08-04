<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page isELIgnored="false"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<h2>Projects Page</h2>
<div>Shows list of all Projects</div>
<div style="background:green;width:30%;color:white">
	<c:out value="${status}" />
</div>

	<form action="/saveProjectStatus.rm" method="GET">
		<select name="projectId" id="projectId">
		<c:forEach items="${projectsList}" var="project">
			<option value="${project.projectid}"> ${project.projectName} </option>
		</c:forEach>
		</select>
		
		<select name="status" id="status">
			<option value="Open For Edit">Open For Edit</option>
			<option value="Expired">Expired</option>
			<option value="Delayed">Delayed</option>
		</select>
		
		<input type="submit" name="btnClick" id="btnClick" value="Save" /> <!-- submits the form -->
	</form>
</body>
</html>


<script language="javascript">


// on page load, set status as per the project status in database
//var projectStatus = $('#projectName').val();


</script>