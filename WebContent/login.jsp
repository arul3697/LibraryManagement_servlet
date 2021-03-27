<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginPage</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<style>
body {
  margin:0;
  padding:0;
  background-image:url("assets/images/loginBackGround.jpg");
  background-size: cover;
}
  .card {
    box-shadow: 0 0px 20px 0 rgba(0,0,0,0.2);
    background-image:url("assets/images/card1.jpg");
    transition: 0.3s;
 }   
</style>
</head>
<body>
	<div class="container" align="center" style="margin-top: 10rem">
		<div class=" col-4 justify-content-center">
			<div class="card">
				<div class="card-header" style="color:darkblue">
					<h3>Login Form</h3>
				</div>
				<div class="card-body">
					<font color="#f21c04">${error}</font> <font color="green">
						${message} </font> <font color="#f21c04"> ${messagelogout} </font>
						<font color="green"> ${sucessmessage} </font>
					<form action="login" method="post">
						<div class="input-group form-group">						
							<input type="text" name="username" class="form-control" 
								placeholder="Username">
						</div>
						<div class="input-group form-group">
							<input type="password" name="password" class="form-control" 
								placeholder="Password"> 
						  </div>						  
						<div class="form-group">
							<input type="submit" name="redirectValue" value="Login"
								class="btn btn-primary">
							</div>			
						<div class="form-group"><a href="resetPassword.jsp" style="margin-left:1px;color:darkgreen">Forget Password ?</a>
						
							<a href="register.jsp" style="margin-left:60px;color:darkgreen">New User?</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>    
</body>
</html>