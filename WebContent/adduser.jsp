<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
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
							<c:when test="${users.id!= null}">
								<h3>Edit User</h3>
							</c:when>
							<c:otherwise>
								<h3>Add User</h3>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="card-body">
						<font color="#f21c04">${error}</font> <font color="#f21c04">${updateError}</font>
						<form class="form-horizontal" action="addUser" method="post">
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">User Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="name" id="name"
											placeholder="Enter Name" required value="${users.name }" />
									</div>
								</div>
							</div>
							<font color="#f21c04">${NameError}</font>
							<c:if test="${users.id == null}">
								<div class="form-group">
									<label for="password" class="cols-sm-2 control-label">Password</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"></span> <input
												type="password" class="form-control" name="password"
												id="password" placeholder="Enter Password" />
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${users.id!= null}">
								<div class="form-group">
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"></span> <input type="hidden"
												class="form-control" name="password" id="password"
												placeholder="Enter Password" required
												value="${users.email_id }" />
										</div>
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<label for="email_id" class="cols-sm-2 control-label">Email
									Id</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="email"
											class="form-control" name="email_id" id="email_id"
											placeholder="Enter Email Id" required
											value="${users.email_id }" />
									</div>
								</div>
							</div>
							<font color="#f21c04">${MailError}</font>
							<div class="form-group">
								<label for="address" class="cols-sm-2 control-label">Address</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="address" id="address"
											placeholder="Enter Address" required
											value="${users.address }" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="contact_number" class="cols-sm-2 control-label">Contact
									Number</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="number"
											min="0" class="form-control" name="contact_number"
											id="contact_number" placeholder="Contact Number" required
											value="${users.contact_number }" />
									</div>
								</div>
							</div>
							<br>
							<font color="#f21c04">${ContactNumberError}</font>
							<c:if test="${users.id == null}">
								<div class="form-group " align="center" class="row">
									<input type="submit" name="redirectValue" value="Add"
										class="btn btn-primary">
									<div class="form-group " align="right">
										<a href="viewUser?redirectValue=view&id=1" title="Back"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i>Back</a>
									</div>
								</div>
							</c:if>
							<c:if test="${users.id!= null}">
								<div class="form-group " align="center" class="row">
									<input type="hidden" name="id" value=${users.id }><input
										type="submit" name="redirectValue" value="Update"
										class="btn btn-primary">
									<div class="form-group " align="right">
										<a href="viewUser?redirectValue=view&id=1" title="Back"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i>Back</a>
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