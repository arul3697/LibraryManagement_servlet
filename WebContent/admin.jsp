<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<style>
body {
  margin:0;
  padding:0;
  background-image:url("assets/images/admin2.jpg");
  background-size: cover;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<form class="form-inline">
			<div >
				<h6>
					<a class="nav-link" href="viewUser?redirectValue=view&id=1" style="color:white" title="View users"><i class="fa fa-users" aria-hidden="true" style="font-size:20px;color:blue"></i></a>
				</h6>
			</div>
			<div>
				<h6>
					<a class="nav-link" href="viewBook?redirectValue=view&id=2" style="color:white" title="View books"><i class="fa fa-book" aria-hidden="true" style="font-size:20px;color:darkorange"></i></a>
				</h6>
			</div>
		</form>
		<form class="form-inline">
		<div align="center" style="color: lightblue">
		<h4>Admin</h4>
		<font color="red"> ${userError} </font> <font color="red">
			${bookError} </font>
	   </div>
	   </form>
		<form class="form-inline my-2 my-lg-0">
			<c:choose>
				<c:when test="${view_id==1}">
					<h6>
						<a href="adduser.jsp" class="nav-link" style="color: white" title="Add users"><i class="fa fa-user-plus" aria-hidden="true" style="font-size:20px;color:lightgreen"></i></a>
					</h6>
				</c:when>
				<c:when test="${view_id==2}">
					<h6>
						<a href="addbook.jsp" class="nav-link" style="color: white" title="Add books"><i class="fa fa-plus-circle" aria-hidden="true" style=font-size:20px;color:lightgreen></i></a>
					</h6>
				</c:when>
			</c:choose>
			<h6>
				<a href="logout" class="nav-link" style="color: white" title="Logout"><i class="fa fa-sign-out" aria-hidden="true" style="font-size:20px;color:red;"></i></a>
			</h6>
		</form>
	</nav>
	<c:choose>
		<c:when test="${view_id== 1}">
			<div class="container" align="center"
				style="margin-top: 2%; margin-left: 8%">
				<form action="viewUser" method="get">
					<h5 style="color: darkblue">User Details</h5>
					<font color="red"> ${deletemessage} </font> <font color="green">
						${message} </font> <font color="green"> ${update} </font> <font
						color="red"> ${Error} </font> <font color="red">
						${deactivateError} </font>
					<table class="table table-hover" style="background-color:lightgray" >
						<thead class="thead-dark">
							<tr>
								<th>S.No</th>
								<th>Name</th>
								<th>Email Id</th>
								<th>Address</th>
								<th>Contact Number</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody >
							<c:forEach items="${users}" var="user" varStatus="counter">
								<tr>
									<td><c:out value="${counter.count }" /></td>
									<td scope="row"><c:out value="${user.name}" /></td>
									<td><c:out value="${user.email_id}" /></td>
									<td><c:out value="${user.address}" /></td>
									<td><c:out value="${user.contact_number}" /></td>
									<td><a href="update?redirectValue=edit&id=${user.id}" title="Edit"><i class="fa fa-pencil-square" aria-hidden="true" style="color:blue"></i></a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="deleteAccount?redirectValue=deleteAccount&id=${user.id}" title="Delete"><i class="fa fa-trash" aria-hidden="true" style="color:red"></i></a>
									</td>
								</tr>
								<input type="hidden" name="id" value=${user.id }>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:when>
		<c:when test="${view_id== 2}">
			<div class="container" align="center"
				style="margin-top: 2%; margin-left: 8%">
				<form action="viewBook" method="get">
					<h5 style="color: darkblue">Book Details</h5>
					<font color="red"> ${deletemessage} </font> <font color="green">
						${message} </font> <font color="green"> ${update} </font> <font
						color="green"> ${updateError} </font> <font color="red">
						${Error} </font> <font color="red"> ${bookError} </font>
					<table class="table table-hover" style="background-color:lightgray">
						<thead class="thead-dark">
							<tr>
								<th>S.No</th>
								<th>Name</th>
								<th>Author Name</th>
								<th>Publisher Name</th>
								<th>Contact Number</th>
								<th>Action</th>
								<!-- <th>Download</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="books" items="${book}" varStatus="counter">
								<tr>
									<td><c:out value="${counter.count }" /></td>
									<td scope="row"><c:out value="${books.name}" /></td>
									<td><c:out value="${books.author_name}" /></td>
									<td><c:out value="${books.publisher_name}" /></td>
									<td><c:out value="${books.contact_number}" /></td>
									<td><a
										href="updateBook?redirectValue=editBook&id=${books.id}" title="Edit"><i class="fa fa-pencil-square" aria-hidden="true" style="color:blue"></i></a>
										&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="deleteBook?redirectValue=deleteBook&id=${books.id}" title="Delete"><i class="fa fa-trash" aria-hidden="true" style="color:red"></i></a>
									</td>
									<%-- <td>
								 <a href="download?redirectValue=download&id=${books.id}">Download</a></td> --%>
								</tr>
								<input type="hidden" name="id" value=${books.id }>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:when>
	</c:choose>
</body>
</html>
