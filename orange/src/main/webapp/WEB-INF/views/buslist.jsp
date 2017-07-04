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
}

body {
	/* background: url("././imgs/bg.jpg"); no-repeat center center fixed; */
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	background-color: #333;
	font-family: 'Open Sans', Arial, Helvetica, Sans-Serif;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />



</head>

<body>
	<div>
		<nav class="navbar navbar-default navbar-fixed-top"
			style="background-color: orange">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header page-scroll">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				<a class="navbar-brand" onclick="location.href='home'"><img src="imgs/logo.png" width="150"
						height="150" class="img-rounded" alt="Rounded Image"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden"><a href="#page-top"></a></li>
						<li class="page-scroll"><a href="?language=mr"
							style="color: white"> <spring:message code="lbl.lang.mr"
									text="Marathi" /></a></li>
						<li class="page-scroll"><a href="?language=en"
							style="color: white"> <spring:message code="lbl.lang.en"
									text="English" /></a></li>
					<li class="page-scroll">
							<c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/login?logout" style="color: white"> <spring:message
									code="global.logout" text="Logout" /></a>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container" style="padding-top: 150px;">
		<div class="table-responsive">
			<table class="table table-hover  table-sm table-bordered"
				style="text-align: center">
				<thead class="table-info"
					style="background-color: orange; text-align: center; color: white">
					<tr>
						<th style="text-align: center"><spring:message
								code="lbl.bus.name" /></th>
						<th style="text-align: center"><spring:message
								code="lbl.bus.time" /></th>
						<th style="text-align: center"><spring:message
								code="lbl.bus.type" /></th>
						<th style="text-align: center"><spring:message
								code="lbl.bus.seatcharge" /></th>
						<th style="text-align: center"><spring:message
								code="lbl.bus.booknow" /></th>
					</tr>
				</thead>

				<form:form action="sub" method="post">
					<tbody>
						<c:forEach var="bus" items="${busList}">

							<tr style="height: 100px;">
								<td><spring:message code="${bus.operatedBy}" /></td>
								<td>${bus.busTime}</td>
								<td><spring:message code="${bus.busType}" /></td>
								<td>${bus.chargePerSeat}</td>
								<td>
									<button name="busid" value="${bus.busid}">Book Now</button>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</form:form>
			</table>
		</div>


	</div>

	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</body>

</html>

