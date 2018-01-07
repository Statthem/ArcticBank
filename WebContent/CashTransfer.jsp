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
		<h1>	Choose card  </h1>
	</div>
	</div>
	<%if (user.getCredit_cards() != null){ %>
	<div class="row">
			<div class="col-md-5">
			<h4>Credit cards:</h4>
			 <form action="CashTransferServlet" method="post">
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
							<label for="id">Destination card id</label> <input type="number"
								class="form-control" name="Dcard_id">
						</div>
	 <div class="form-group">
							<label for="summ">Transfer sum (USD)</label> <input type="number"
								class="form-control" type=number step=0.01 min=0 name="summ">
						</div>					
						
      <button type="submit" class="btn btn-primary">transfer</button>
    	 </form>
  
	</div>
	<div class="col-md-5 col-md-offset-1">
	<h4> Money transfer between ArcticBank credit card completely for free</h4>
	
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