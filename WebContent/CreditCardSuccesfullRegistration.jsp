<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Credit card registration</title>
<meta name="description" content="">
<meta name="author" content="Statthem">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">
<title>Credit card succesfull registration page</title>
<style type="text/css">
body {
    text-align: center;
     font-size: 24px;
}
</style>
</head>
<body link="#1fc68c">
			<%
String card_id = null;
card_id  = String.valueOf(request.getSession().getAttribute("card_id"));
%>
<br>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
	



				<label for="card_id">Your card id: <%= card_id %>  </label> 
				<a href ="WelcomePage.jsp">return to main page</a>
			</div>
		</div>
	</div>
	

</body>

</html>
