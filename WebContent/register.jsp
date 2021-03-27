<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header" align="center">
						<h3>Register Form</h3>
					</div>
					<div class="card-body">
						<font color="#f21c04">${error}</font>
						<form class="form-horizontal" action="register" method="post">
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">User Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="text"
											class="form-control" name="name" id="name"
											placeholder="Enter User Name" />
									</div>
								</div>
							</div>
							<font color="#f21c04">${NameError}</font>							
							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Password</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="password"
											class="form-control" name="password" id="password"
											placeholder="Enter Password" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="email_id" class="cols-sm-2 control-label">Email
									Id</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="email"
											class="form-control" name="email_id" id="email_id"
											placeholder="Enter Email Id" />
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
											placeholder="Enter Address" />
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
											id="contact_number" placeholder="Contact Number" />
									</div>
								</div>
							</div>
							<font color="#f21c04">${ContactNumberError}</font>
							<div class="form-group row=1" align="center">
								<input type="submit" name="redirectValue" value="Register"
									class="btn btn-primary">
								<div class="form-group" align="right">
									<a href="login.jsp" title="Login page"><i class="fa fa-arrow-circle-left" aria-hidden="true" style="font-size:25px"></i></a>
								</div>
							</div>

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>