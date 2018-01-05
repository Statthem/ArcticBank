package webapp.arcticbank.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CashTransferServlet")
public class CashTransferServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("card_id");
		Long card_id = Long.valueOf(id);

		String transferSumm = req.getParameter("transferSumm");
		BigDecimal summ = new BigDecimal(transferSumm);

	}

}
