<%@ page import="webapp.arcticbank.model.User"%>
<%@ page import="webapp.arcticbank.model.CreditCard"%>
<%@ page import="java.util.Iterator"%>
<%@ page session="true" %>
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
#wrapper {
height: 300px;
position:relative;
 background-image: url("money.jpg"),
}
#bottomDweller {
position: absolute; bottom:0;}
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
					
										<li>
						<form action="LogOutServlet" method="post">
							<button type="submit" class="btn btn-default">Log out</button>
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</head>
<body>
<br>
<br>
<br>
<br>
<%
User user = (User) request.getSession().getAttribute("current_user");
%>
<div class="container">
		<div class="row">
			<div class="col-md-3">
		<h1>	New deposit  </h1>
		<br>
		<br>
		<br>
	</div>
	</div>
	<%if (user.getCredit_cards() != null){ %>
	<div class="row">
			<div class="col-md-6">
			<h4>Credit cards:</h4>
			 <form action="DepositCreationServlet" method="post">
			  <select name="Scard_id" id="card_id">
     <%
     Iterator<CreditCard> iterator = user.getCredit_cards().iterator();
     while(iterator.hasNext()){
    	 CreditCard card = iterator.next(); %>
  <option value="<%= card.getCard_id() %>"> <%= card.getCard_id() %> </option>
    <% 	 
     }
	}else{ response.sendRedirect("WelcomePage.jsp");}
     %>
     
      </select> 
      <div class="form-group">
							your deposit will be active for 
							<select name="active_date">
							 <option value="2 months"> 2 months </option>
							  <option value="6 months"> 6 months </option>
							   <option value="1 year"> 1 year </option>
							    <option value="1,5 year"> 1,5 year </option>
							     <option value="3 years"> 3 years</option>
							</select>
							
						</div>
	 <div class="form-group">
							<label for="summ">deposit balance (USD, minimum - 100)</label> <input type="number"
								class="form-control" type=number step=0.01 min=100 name="summ">
						</div>					
						
      <button type="submit" class="btn btn-primary">confirm</button>
    	 </form>
  
	</div>
	<div class="col-md-5 col-md-offset-1">
	<h4> Conditions:</h4>
	<p>gain 4% from starting balance every month;</p>
	<p>you can't use money on deposit until it's expires</p>
	</div>
	</div>
	
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="wrapper">
     <div id="bottomDweller"><p></p></div>
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