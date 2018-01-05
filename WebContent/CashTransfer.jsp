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
		<h1>	Chose card  </h1>
	</div>
	</div>
	<%if (user.getCredit_cards() != null){ %>
	<div class="row">
			<div class="col-md-4">
			<h4>Credit cards:</h4>
			 <form action="CashTransferServlet" method="post">
			  <select name="card_id" id="card_id">
     <%
     Iterator<CreditCard> iterator = user.getCredit_cards().iterator();
     while(iterator.hasNext()){
    	 CreditCard card = iterator.next(); %>
  <option value="<%= card.getCard_id() %>"> <%= card.getCard_id() %> </option>
    <% 	 
     }
	}
     %>
     
      </select> 
      <button type="submit" class="btn btn-primary">choose</button>
    	 </form>
  
	</div>
	</div>
	
	</div>
	
	
</body>
</html>