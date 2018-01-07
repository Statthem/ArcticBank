<%@ page import="webapp.arcticbank.model.User"%>
<%@ page import="webapp.arcticbank.model.CreditCard"%>
<%@ page import="webapp.arcticbank.model.Deposit"%>
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
<style type="text/css">
	body{
  font-family: "Times New Roman", Times, serif;
  font-size: 25px;
}
	</style>	
</head>

<body>
<%
User user = (User) request.getSession().getAttribute("current_user");
%>
<div class="container">
		<div class="row">
			<div class="col-md-3">
			<h1>Personal information</h1>
 <p>	Name: <%= user.getFirst_name() %> </p>
 <p>    SurName: <%= user.getSecond_name() %> </p>
  <p>	Email: <%= user.getEmail()%> </p>
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
    	 String balance = "0";
    	 if(card.getBalance() == null){ 
    		 balance = "0.00";
    	 }else{balance = card.getBalance().toString(); 
    	 }
    	 out.println("card id: " + card.getCard_id() + "              balance: " + balance + " USD");
    	 %> <br> <%
     }
     
	}
     %>
  
	</div>
	<%if (user.getDeposits() != null){ %>
	<div class="col-md-6">
			<h4>Deposits:</h4>
			<% 
			Iterator<Deposit> iterator = user.getDeposits().iterator();
			while(iterator.hasNext()){
				Deposit deposit = iterator.next();
				out.println("balance: " + deposit.getBalance() + " creation date: " + deposit.getCreation_date() + " expiration date: " + deposit.getExpiration_date());
			%>
			<%
			}
	}
			%>
	</div>
	
	</div>
	
	
</body>
</html>