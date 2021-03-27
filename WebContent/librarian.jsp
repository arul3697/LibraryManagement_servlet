<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Page</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<style>
body {
  margin:0;
  padding:0;
  background-image:url("assets/images/library2.jpg");
  background-size: cover;
}
</style>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<form class="form-inline">
			<div>
				<h6>
					<a class="nav-link" href="viewBook?redirectValue=views&id=3" style="color:white" title="View Books"><i class="fa fa-book" aria-hidden="true" style=font-size:20px;color:darkorange></i></a>
				</h6>
			</div>
		</form>
		<form class="form-inline">
		<div style="color: lightblue">
		<h4>Librarian Admin</h4>
	   </div>	   
	  <font color="red"> ${bookError} </font>
	  </form>
		<form class="form-inline my-2 my-lg-0">
			<c:if test="${view_id==3}">
				<h6>
					<a href="addLibrarianBook.jsp" class="nav-link"
						style="color:white" title="Add Book"><i class="fa fa-plus-circle" aria-hidden="true" style=font-size:20px;color:lightgreen></i></a>
				</h6>
			</c:if>
			<h6>
				<a href="logout" class="nav-link" style="color: white" title="Logout"><i class="fa fa-sign-out" aria-hidden="true" style="font-size:20px;color:red;"></i></a>
			</h6>
		</form>
	</nav>

	<c:if test="${view_id== 3}">
		<div class="container" align="center"
			style="margin-top: 2%; margin-left: 8%">
			<form action="viewBook" method="get">
				<h5 style="color: lightgray">Book Details</h5>
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
									href="updateBook?redirectValue=editBooks&id=${books.id}" title="Edit"><i class="fa fa-pencil-square" aria-hidden="true" style="color:blue"></i></a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="deleteBook?redirectValue=deleteBooks&id=${books.id}" title="Delete"><i class="fa fa-trash" aria-hidden="true" style="color:red"></i></a>									
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
	</c:if>
</body>
</html>