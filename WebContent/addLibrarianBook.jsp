<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4 ">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header" align="center">
						<c:choose>
							<c:when test="${book.id!= null}">
								<h3>Edit Book</h3>
							</c:when>
							<c:otherwise>
								<h3>Add Book</h3>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="card-body">
						<font color="#f21c04">${error}</font> <font color="#f21c04">${updateError}</font>
						<form class="form-horizontal" action="addBook" method="post">
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Book Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="name" id="name"
											placeholder="Enter Book Name" required value="${book.name }" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="author_name" class="cols-sm-2 control-label">Author
									Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="author_name" id="author_name"
											placeholder="Enter Author Name" required
											value="${book.author_name }" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="publisher_name" class="cols-sm-2 control-label">Publisher
									Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="publisher_name"
											id="publisher_name" placeholder="Enter Publisher Name"
											required value="${book.publisher_name }" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="contact_number" class="cols-sm-2 control-label">Contact
									Number</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="number"
											class="form-control" name="contact_number"
											id="contact_number" placeholder="Contact Number" required
											value="${book.contact_number }" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="files" class="cols-sm-2 control-label">choose files
								   </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<%-- <span class="input-group-addon"></span> <input type="file"
											min="0" class="form-control" name="file" 
											id="file" required
											value="${book.fileName}" /> --%>
											 <div class="custom-file">
                                              <input type="file" class="custom-file-input" name="file"id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"  required
											value="${book.fileName}"  >
                                              <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                                         </div>
									</div>
								</div>
							</div>
							<br>
							<c:if test="${book.id == null}">
								<div class="form-group " align="center" class="row">
									<input type="submit" name="redirectValue" value="Submit"
										class="btn btn-primary">
									<div class="form-group " align="right">
										<a href="viewBook?redirectValue=views&id=3" title="Back"><i class="fa fa-arrow-circle-left" aria-hidden="true" style="font-size:23px"></i></a>
									</div>
								</div>
							</c:if>
							<c:if test="${book.id!= null}">
								<div class="form-group " align="center" class="row">
									<input type="hidden" name="id" value=${book.id }><input
										type="submit" name="redirectValue" value="Confirm"
										class="btn btn-primary">
									<div class="form-group " align="right">
										<a href="viewBook?redirectValue=views&id=3" title="Back"><i class="fa fa-arrow-circle-left" aria-hidden="true" style="font-size:23px"></i></a>
									</div>
								</div>
							</c:if>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>