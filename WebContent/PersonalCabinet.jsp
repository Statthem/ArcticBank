<%@ page import="webapp.arcticbank.model.User"%>
<%@ page import="webapp.arcticbank.model.CreditCard"%>
<%@ page import="webapp.arcticbank.model.Deposit"%>
<%@ page import="webapp.arcticbank.DAO.CreditCardDAO"%>
<%@ page import="java.util.Iterator"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cabinet</title>
<meta name="description" content="">
<meta name="author" content="">


<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/modernizr.custom.js"></script>
	
	
<style type="text/css">
	body{
  font-size: 25px;
}
	</style>	
</head>

<body>
<%
User user = (User) request.getSession().getAttribute("current_user");
CreditCardDAO cardDAO = new CreditCardDAO();
user.setCredit_cards(cardDAO.getUserCards(user));
String date = null;
if(user.getDate_of_birthday() == null){ date = "empty";
}else{date = user.getDate_of_birthday().toString(); }
%>
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


<br>
<br>
<div class="container">
		<div class="row">
			<div class="col-md-4">
			<h1>Personal information</h1>
 <p>	Name: <%= user.getFirst_name() %> </p>
 <p>    SurName: <%= user.getSecond_name() %> </p>
  <p>	Email: <%= user.getEmail()%> </p>
   <p>	Date of birthday: <%= date %> </p>
  
	</div>
	<div class="col-md-1">
	</div>
	<div class="col-md-4">
	<br>
	<img src="img/userPhoto.jpg" class="img-responsive">
	</div>
	</div>
	
	<br>
	<br>
	<%if (user.getCredit_cards() != null){ %>
	<div class="row">
			<div class="col-md-4">
			<h1>Credit cards:</h1>
     <%
     Iterator<CreditCard> iterator = user.getCredit_cards().iterator();
     while(iterator.hasNext()){
    	 CreditCard card = iterator.next();
    	 String balance = "0";
    	 if(card.getBalance() == null){ 
    		 balance = "0.00";
    	 }else{balance = card.getBalance().toString(); 
    	 }
    	%><h1>balance:</h1> <span class="count"><%= balance %></span><% out.println(" USD. " +  " card id: " + card.getCard_id() +"."); %> <br> <%
     }
     
	}
     %>
  
	</div>
	<%if (user.getDeposits() != null){ %>
	<div class="col-md-1">
	</div>
	<div class="col-md-7">
			<h1>Deposits:</h1>
			<% 
			Iterator<Deposit> iterator = user.getDeposits().iterator();
			while(iterator.hasNext()){
				Deposit deposit = iterator.next();
				out.println("balance: " + deposit.getBalance() + " creation date: " + deposit.getCreation_date() + " expiration date: " + deposit.getExpiration_date());
			%>
			<br>
			<%
			
			}
	}
			%>
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