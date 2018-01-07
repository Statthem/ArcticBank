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


<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">
	
	<style type="text/css">

body{
  font-family: "Times New Roman", Times, serif;
  font-size: 28px;
}
#wrapper {
height: 300px;
position:relative;
background-color: #a8eaff;
}
#bottomDweller {
position: absolute; bottom:0;}
</style>
</head>
<body>
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
	
	
	
	
</body>
</html>