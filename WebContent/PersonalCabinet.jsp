<%@ page import="webapp.arcticbank.model.User"%>
<%@ page import="webapp.arcticbank.model.CreditCard"%>
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
	href="BootStrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="BootStrap/fonts/font-awesome/css/font-awesome.css">
</head>
<body>
<%
User user = (User) request.getSession().getAttribute("current_user");
%>
<div class="container">
		<div class="row">
			<div class="col-md-3">
			<h4>Personal information</h4>
 <p>	Name: <%= user.getFirst_name() %> </p>
 <p>    SurName: <%= user.getSecond_name() %> </p>
  <p>	Email <%= user.getEmail()%> </p>
   <p>	Date of birthday: <%= user.getDate_of_birthday()%> </p>
  
	</div>
	</div>
	<%if (user.getCredit_cards() != null){ %>
	<div class="row">
			<div class="col-md-4">
			<h4>Credit cards:</h4>
     <%
     Iterator<CreditCard> iterator = user.getCredit_cards().iterator();
     while(iterator.hasNext()){
    	 CreditCard card = iterator.next();
    	 out.println("card id: " + card.getCard_id() + "         balance: " + card.getBalance() + " USD");
    	 %> <br> <%
     }
     
	}
     %>
  
	</div>
	</div>
	
	</div>
	
	
</body>
</html>