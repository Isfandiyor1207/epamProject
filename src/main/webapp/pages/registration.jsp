<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="../fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="controller" class="register-form" id="register-form">
							<input type="hidden" name="command" value="add_user">
							<div class="form-group">
								<label for="firstname"><i
									class="zmdi zmdi-account material-icons-name"></i></label>
								<input type="text" name="firstname" id="firstname" placeholder="Your Firstname" />
							</div>
							<div class="form-group">
								<label for="lastname"><i class="zmdi zmdi-account material-icons-name"></i></label>
								<input type="text" name="lastname" id="lastname" placeholder="Your Lastname" />
							</div>
							<div class="form-group">
								<label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
								<input type="text" name="username" id="username" placeholder="Username" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label>
								<input type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label>
								<input type="password" name="password" id="password" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="psw_repeat"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="psw_repeat" id="psw_repeat" placeholder="Repeat your password" />
							</div>
							<div><small style="color: red">${psw_repeat}</small></div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact" placeholder="Contact no" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
								<label for="agree-term" class="label-agree-term"><span><span></span></span>
									I agree all statements in <a href="#" class="term-service">Terms of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="add_user" id="add_user" class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="../img/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="main.jsp" class="signup-image-link">I am already member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="../js/main.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>