<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="user.css">

	<c:if test = "${!(empty alert )}">
		<style type='text/css'>
			#fn {border-color:${alert.getFieldBgColor(0)}}
			#ln {border-color:${alert.getFieldBgColor(1)}}
			#pn {border-color:${alert.getFieldBgColor(2)}}
			#em {border-color:${alert.getFieldBgColor(3)}}
		</style>

	</c:if>
</head>
<body>



	<form  action="<c:url value="/users"/>" accept-charset="utf-8" method="post">
		<div class="main">
						<h2> Edit user </h2>
						<input type="hidden" name="userId" value="${user.id}">

						<div class="field">
							<c:if test="${!(empty alert )}">

									<b class="errorText">
											${alert.message}
									</b>
							</c:if>
						</div>
			  			<div class="field">
			  				<label for="fn"> First Name:</label> 
			  				<input type="text" name="firstName" value="${user.firstName}" id="fn">
			  			</div>
			  			<div class="field">
			 				<label for="ln">Last Name </label>
			 				<input type="text" name="lastName" value="${user.lastName}" id="ln">
			 			</div>
			 			<div class="field">
			 		 		<label for="pn">Phone:</label>
			 				<input type="text" name="phone" value="${user.phone}" id="pn"> 
						</div>
						<div class="field">
							<label for="em">Email: </label>
						 	<input type="text" name="email" value="${user.email}" id="em">
						</div> 
						<div class="sbm-btn">
							<input type="submit"  name="command" value="Save" />
						</div>
		</div>
	</form>

</body>
</html>