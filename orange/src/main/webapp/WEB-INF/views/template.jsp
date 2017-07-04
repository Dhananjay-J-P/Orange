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
					<a class="navbar-brand" onclick="location.href='home'"><img
						src="imgs/logo.png" width="150" height="150" class="img-rounded"
						alt="Rounded Image"></a>
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
						<li class="page-scroll"><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/login?logout" style="color: white"> <spring:message
									code="global.logout" text="Logout" /></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container" style="padding-top: 150px;">

		 <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>

	</div>

	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</body>

</html>

