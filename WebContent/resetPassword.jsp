<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 9rem">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header" align="center">
                       <h5>Forget Password</h5>
					</div>
					<div class="card-body">
						<font color="#f21c04">${errormessage}</font>
						<form class="form-horizontal" action="reset" method="post">
						<div class="form-group">
								<label for="email_id" class="cols-sm-2 control-label">Email Id</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="email"
											class="form-control" name="email_id" id="email_id"
											placeholder="Enter email id" />
									</div>
								</div>
								</div>
							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label">Password</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"></span> <input type="password"
											class="form-control" name="newpassword" id="newpassword"
											placeholder="Enter New password" />
									</div>
								</div>
							</div>
								<div class="form-group">
									<label for="password" class="cols-sm-2 control-label">Confirm Password</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"></span> <input
												type="text" class="form-control" name="confirmpassword"
												id="confirmpassword" placeholder="Enter Confirm Password" />
										</div>
									</div>
								</div>
								<div class="form-group " align="center">
								  <input
										type="submit" name="redirectValue" value="Reset"
										class="btn btn-primary">							
								<div align="right"><a href="login.jsp" title="Back"><i class="fa fa-arrow-circle-left" aria-hidden="true" style="font-size:25px"></i></a></div></div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>