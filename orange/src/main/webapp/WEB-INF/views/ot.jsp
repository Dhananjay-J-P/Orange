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
	<form:form action="oTT" method="post" modelAttribute="test"
		class="form-horizontal">
		<table>
			<tr>
				<td>Interests:</td>
				<td>
					<%-- Approach 2: Property is of an array or of type java.util.Collection --%>
					Quidditch: <form:checkbox path="interests" value="Quidditch" />
					Herbology: <form:checkbox path="interests" value="Herbology" />
					Defence Against the Dark Arts: <form:checkbox path="interests"
						value="Defence Against the Dark Arts" />
				</td>

			</tr>

		</table>
		<button id="saveCustomer" class="btn btn-primary">
			<spring:message code="global.search" />
			<i class="fa fa-sign-in"></i>
		</button>

	</form:form>



	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</body>

</html>

