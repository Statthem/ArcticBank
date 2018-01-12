<%@ page import="webapp.arcticbank.currencies.*"%>
<%@ page import="webapp.arcticbank.model.CreditCard"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cash Transfer</title>
<meta name="description" content="">
<meta name="author" content="">



	<style type="text/css">

body{
  font-size: 28px;
}
</style>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">

<link rel="stylesheet" type="text/css" href="css/registration.css">
<title>Registration page</title>
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
	<nav id="menu" class="navbar navbar-default2 navbar-fixed-top">
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
					<li><a href="WelcomePage.jsp" class="page-scroll">Home</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</head>
<body>
<%Rates rates = HttpGet.getCurrencies(); %>
<br>
<br>
<br>
<br>
<br>

<h2>Currencies</h2>
<br>
  <p>Here you can see live currencies</p>  
<table class="table">    
    <thead>
      <tr>
        <th>Currency</th>
        <th>Value</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>USD/EUR</td>
        <td><%= rates.getEUR() %></td>
      </tr>
      <tr>
        <td>USD/RUB</td>
        <td><%= rates.getRUB() %></td>
      </tr>
      <tr>
        <td>USD/UAH</td>
        <td><%= rates.getUAH() %></td>
      </tr>
       <tr>
        <td>USD/CNY</td>
        <td><%= rates.getCNY() %></td>
      </tr>
       <tr>
        <td>USD/JPY</td>
        <td><%= rates.getJPY() %></td>
      </tr>
       <tr>
        <td>USD/GBP</td>
        <td><%= rates.getGBP() %></td>
      </tr>
    </tbody>
  </table>


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