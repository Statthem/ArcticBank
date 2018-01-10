
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Arctic</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">

<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/modernizr.custom.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Navigation
    ==========================================-->
	<nav id="menu" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="WelcomePage.jsp"><i
					class="fa fa-sun-o"></i> Arctic<strong></strong></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#home" class="page-scroll">Home</a></li>
					<li><a href="#services-section" class="page-scroll">Services</a></li>
					<li><a href="#about-section" class="page-scroll">About</a></li>
					<li><a href="#contact-section" class="page-scroll">Contact</a></li>
						<%
						if (request.getSession().getAttribute("admin") != null) {
					%>
					<li> <a href = "AdminPanel.jsp" class="page-scroll">Admin panel</a></li>
					<%
						} if (request.getSession().getAttribute("current_user") == null) {
					%>
					<li><a href="#login-section" class="page-scroll">Login</a></li>
					<%
						} else {
					%>
					<li> <a href = "PersonalCabinet.jsp" class="page-scroll">My personal cabinet</a></li>
					<li>
						<form action="LogOutServlet" method="post">
							<button type="submit" class="btn btn-default">Log out</button>
						</form>
					</li>
					<%
						}
					%>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header class="text-center" name="home">
		<div class="intro-text">
			<h1>
				Welcome to<strong> Arctic Bank</strong>
			</h1>
			<p>Best bank in Ukraine</p>
			<a href="#services-section"
				class="btn btn-default btn-lg page-scroll">LEARN MORE</a>
		</div>
	</header>
	<br>
	
	<%
		if (request.getSession().getAttribute("current_user") == null) {
	%>

	<!-- Login Section -->
	<div id="login-section" class="text-center">
		<div class="container">
		<div class="section-title center">
				<h2>Sign in</h2>
				<hr>
			<div class="row"
				style="background: transparent url('imgs/dark.jpg') no-repeat center center/cover">
				<div class="col-md-3">

					<form action="LoginServlet" method="post">
						<div class="form-group">
							<label for="email">Email address:</label> <input type="email"
								class="form-control" id="email" name="user_email">
						</div>
						<div class="form-group">
							<label for="pwd">Password</label> <input type="password"
								class="form-control" id="pwd" name="password">
						</div>
						<div class="checkbox">
							<label><input type="checkbox"> Remember me</label> not
							registered? <a href="RegistrationPage.html"> Register here!</a>
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
					</form>

				</div>
				<div class="col-md-5 col-md-offset-1">
	<p>Only authorized users can gain access<p>
	<p>to all services we providing them </p>
	
	</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<!-- Services Section -->
	<div id="services-section" class="text-center">
		<div class="container">
			<div class="section-title center">
				<h2>Our Services</h2>
				<hr>
				<div class="clearfix"></div>
				<p>We provide a lot of services)</p>
			</div>
			<div class="space"></div>
			<div class="row">
				<div class="col-md-3 col-sm-6 service">
					<i class="fa fa-desktop"></i>
					<h4>New credit-card registration</h4>
					<p>
						<%
							if (request.getSession().getAttribute("current_user") != null) {
						%>
						<a href="CreditCardRegistration.html">Register new credit card </a>
						<%
							} else {
						%>
						Registered users only.
						<%
							}
						%>
					</p>
				</div>
				<div class="col-md-3 col-sm-6 service">
					<i class="fa fa-gears"></i>
					<h4>Cash transfer</h4>
					<p><%
							if (request.getSession().getAttribute("current_user") != null) {
						%>
						<a href="CashTransfer.jsp">Cash transfer</a>
						<%
							} else {
						%>
						Registered users only.
						<%
							}
						%>
						</p>
				</div>
				<div class="col-md-3 col-sm-6 service">
					<i class="fa fa-rocket"></i>
					<h4>Deposit</h4>
					<p><%
							if (request.getSession().getAttribute("current_user") != null) {
						%>
						<a href="DepositCreation.jsp">Create new deposit</a>
						<%
							} else {
						%>
						Registered users only.
						<%
							}
						%></p>
				</div>
				<div class="col-md-3 col-sm-6 service">
					<i class="fa fa-line-chart"></i>
					<h4>Currencies</h4>
					<p><a href="https://www.dailyfx.com/forex-rates">Watch live currencies</a>
						</p>
				</div>
			</div>
			
		</div>
	</div>
	<!-- About Section -->
	<div id="about-section">
		<div class="container">
			<div class="section-title text-center center">
				<h2>About Arctic Bank</h2>
				<hr>
				<div class="clearfix"></div>
				<p>Our money - your rules</p>
			</div>
			<div class="row">
				<div class="col-md-6">
					<img src="img/about2.jpg" class="img-responsive">
				</div>
				<div class="col-md-6">
					<div class="about-text">
						<h4>Why Choose Us</h4>
						<p>We are the best;</p>
						<p>Statthem - developer;</p>
						<p>Arctic = cool;</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Achievements Section -->
	<div id="achievements" class="section dark-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">199</span>
						<h4>Clients in total</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">100</span>
						<h4>Working hours</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">602145.50</span>
						<h4>Money transfered</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">0</span>
						<h4>Awards won</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact Section -->
	<div id="contact-section" class="text-center">
		<div class="container">
			<div class="section-title center">
				<h2>Contact Us</h2>
				<hr>
				<p>You can contact find us in our place</p>
				<p></p>
			</div>
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-4">
					<i class="fa fa-map-marker"></i>
					<p>
						3 Lesi Ukrinku Str.,<br> Kiev, CA 13333
					</p>
				</div>
				<div class="col-md-4">
					<i class="fa fa-envelope-o"></i>
					<p>alex-***@ukr.net</p>
				</div>
				<div class="col-md-4">
					<i class="fa fa-phone"></i>
					<p>+44 123 456 1234</p>
				</div>
				<hr>
				<div class="clearfix"></div>
			</div>
			
		</div>
	</div>
	</div>
	<div id="footer">
		<div class="container">
			<div class="fnav">
				<p>contact phone:09686571**</p>
				<p>
					Our base: UKRAINE; copyright<a href="https://www.google.com.ua/">
						HERE 
				</p>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.1.11.1.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/SmoothScroll.js"></script>
	<script type="text/javascript" src="js/jquery.counterup.js"></script>
	<script type="text/javascript" src="js/waypoints.js"></script>
	<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript" src="js/jquery.isotope.js"></script>
	<script type="text/javascript" src="js/jqBootstrapValidation.js"></script>


	<!-- Javascripts
    ================================================== -->
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>