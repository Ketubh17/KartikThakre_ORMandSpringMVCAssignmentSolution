<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Relational Management</title>
</head>

<body>

	<div class="container">

		<h3 align="center">Customer Relational Management</h3>
		<hr>

		

		

			<!-- Add a button -->
			<a href="/CustomerRelationalManagement/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a> 
			



		</form>

		<table class="table table-bordered table-striped">
			<thead bgcolor="#ebebeb">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>email</th>
					<th>operation</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${customers}" var="tempcustomer">
					<tr>
						<td><c:out value="${tempcustomer.firstName}" /></td>
						<td><c:out value="${tempcustomer.lastName}" /></td>
						<td><c:out value="${tempcustomer.email}" /></td>
						
						<td>
							<!-- Add "update" button/link --> 
							<a href="/CustomerRelationalManagement/customer/showFormForUpdate?customerId=${tempcustomer.id}"
							class="btn btn-info btn-sm"> Update </a> 
							
							<!-- Add "delete" button/link -->
							<a href="/CustomerRelationalManagement/customer/delete?customerId=${tempcustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer data?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>