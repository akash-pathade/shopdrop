<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ShopDrop - ${pageTitle}</title>

<script>
	window.menu = '${pageTitle}';
	window.contextRoot ='${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap theme-->
<link href="${css}/bootstrapTheme.css" rel="stylesheet">

<!-- Datatable CDN-->
<link href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shopdrop-homepage.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/nav.jsp"%>


		<!-- Page Content -->
		<div class="content">

			<!-- Load Homepage -->
			<c:if test="${ userClickHome==true}">
				<%@include file="./home.jsp"%>
			</c:if>

			<!-- Load About -->
			<c:if test="${ userClickAbout==true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<!-- Load Products -->
			<c:if
				test="${ userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@include file="./listProducts.jsp"%>
			</c:if>
			
			<!-- Show single Product -->
			<c:if
				test="${ userClickSingleProduct==true}">
				<%@include file="./singleProduct.jsp"%>
			</c:if>
			
			<!-- Show Manage Products -->
			<c:if
				test="${ userClickManageProducts==true}">
				<%@include file="./manageProducts.jsp"%>
			</c:if>
			
			

			<!-- Load Contact -->
			<c:if test="${ userClickContact==true}">
				<%@include file="./contact.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Jquery DataTable CDN -->
		<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
		</script> <!-- Custom js  --> <script src="${js}/myapp.js"></script>
	</div>
</body>

</html>