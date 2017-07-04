<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title><spring:message code="lbl.title.welcome" text="Welcome" /></title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

body {
	background: url("././imgs/bg.jpg"); no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: white;
	background-color: #333;
	font-family: 'Open Sans', Arial, Helvetica, Sans-Serif;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />

</head>

<body onload='document.loginForm.username.focus();'>
	<div class="container" style="color: white">

		<div id="normal" class="text-right">
			<a href="?language=mr"> <spring:message code="lbl.lang.mr"
					text="Marathi" /></a> | <a href="?language=en"> <spring:message
					code="lbl.lang.en" text="English" /></a>
		</div>
		<div class="row">
			<div class="col-md-offset-5 col-md-2 ">
				<img src="imgs/logo.png" width="200" height="200"
					class="img-rounded" alt="Rounded Image">
			</div>
			<div class="col-md-5 ">
				<h1 class="text-center">
					<strong><spring:message code="lbl.header.text" /></strong> <sub><small><spring:message
								code="lbl.header.text.sub" /></small></sub>
				</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-5 col-md-6">
				<%-- <form:form name="loginForm"
					action="<c:url value='j_spring_security_check' />" method="post"
					class="form-horizontal">
					<div class="row">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 col-xs-3 control-label"> <spring:message
										code="lbl.loginId" text="User id" />
								</label>
								<div class="col-md-4 col-xs-4 ">
									<input type="text" class="form-control  chat-input" />
								</div>
								<br />
								<div class="col-md-4 col-xs-5">
									<form:errors cssClass="error" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 col-xs-3 control-label"
									for="customerFirstname"> <spring:message
										code="lbl.password" text="Password" />
								</label>
								<div class="col-md-4 col-xs-4">
									<input type="password" class="form-control  chat-input" />
								</div>

								<div class="col-md-4 col-xs-5">
									<form:errors cssClass="error" />
								</div>
							</div>


						</fieldset>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</form:form> --%>
				<form name='loginForm'
					action="<c:url value='j_spring_security_check' />" method='POST'>







					<table>
						<tr>
							<td>User:</td>
							<td><input type='text' name='username' value=''></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type='password' name='password' /></td>
						</tr>
						<tr>
							<td colspan='2'><input name="submit" type="submit"
								value="submit" /></td>
						</tr>
					</table>





					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</form>
				<c:if test="${not empty actionError}">

					<div class="row">
						<div class="form-group">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<p class="text-danger">${actionError}</p>
							</div>

							<div class="col-md-4"></div>
						</div>

					</div>
				</c:if>

				<c:if test="${not empty error}">

					<div class="row">
						<div class="form-group">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<p class="text-danger">${error}</p>
							</div>

							<div class="col-md-4"></div>
						</div>

					</div>

				</c:if>

				<c:if test="${not empty msg}">

					<div class="row">
						<div class="form-group">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<p class="text-danger">${msg}</p>
							</div>

							<div class="col-md-4"></div>
						</div>

					</div>

				</c:if>







				<div class="row">
					<fieldset>
						<div class="form-group">

							<div class="col-md-offset-4  col-xs-offset-4 col-md-4 col-xs-4">
								<button id="saveCustomer" class="btn btn-primary">
									<spring:message code="global.login" />
									<i class="fa fa-sign-in"></i>
								</button>
							</div>

							<div class="col-md-4"></div>
						</div>
					</fieldset>
				</div>

			</div>
		</div>
	</div>

	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</body>

</html>

