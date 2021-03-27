<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<style>
body {
  margin:0;
  padding:0;
  background-image:url("assets/images/library1.jpg");
  background-size: cover;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<form class="form-inline">
			<div>
				<h6>
					<a class="nav-link"
						href="userViewBook?redirectValue=viewUserBook&id=4" style="color:white" title="View Books"><i class="fa fa-book" aria-hidden="true" style=font-size:20px;color:darkorange></i></a>
				</h6>
			</div>
		</form>
		<form class="form-inline">
		<div style="color: lightblue">
		<h5>Welcome ${userName}</h5>
	   </div>	   
	  <font color="red"> ${bookError} </font>
	  </form>
		<form class="form-inline my-2 my-lg-0">
			<h6>
				<a href="logout" class="nav-link" style="color:white" title="Logout"><i class="fa fa-sign-out" aria-hidden="true" style="font-size:20px;color:red;"></i></a>
			</h6>
		</form>
	</nav>
	<c:if test="${view_id == 4 }">
		<div class="container" align="center"
			style="margin-top: 2%; margin-left: 8%">
			<h5 style="color:lightgray">Books</h5>
			<form action="viewBook" method="get">
				<table class="table table-hover" style="background-color:dark">
					<thead class="thead-dark">
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>Author Name</th>
							<th>Publisher Name</th>
							<th>Contact Number</th>
							<th>Download</th>
						</tr>
					</thead>
					<tbody style="background-color:lightgray">
						<c:forEach var="books" items="${book}" varStatus="counter">
							<tr>
								<td><c:out value="${counter.count }" /></td>
								<td scope="row"><c:out value="${books.name}" /></td>
								<td><c:out value="${books.author_name}" /></td>
								<td><c:out value="${books.publisher_name}" /></td>
								<td><c:out value="${books.contact_number}" /></td>
								<td>
								 <a href="download?redirectValue=download&id=${books.id}" title="Download"><i class="fa fa-download" aria-hidden="true" style="color:green;"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</c:if>
</body>
</html>