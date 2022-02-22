package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*@WebServlet("/productRegistrationServlet")*/
public class ProductRegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String regex = "^[1-9][0-9]*$";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		//Validate the inputs
		if(!validID(id))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h4><span style='color:red'>That ID <q>" + id + "</q> does not match the numeric format or is too big.</h4>");
			response.getWriter().println("<br><form method=\"post\" action=\"product.html\"><button type=\"submit\">Try Again</button></form>");
		}
		else if(name.equals(""))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h4><span style='color:red'>That Name <q>" + name + "</q> is invalid.</h4>");
			response.getWriter().println("<br><form method=\"post\" action=\"product.html\"><button type=\"submit\">Try Again</button></form>");
		}
		else if(description.equals(""))
		{
			response.setContentType("text/html");
			response.getWriter().println("<h4><span style='color:red'>That Description <q>" + description + "</q> is invalid.</h4>");
			response.getWriter().println("<br><form method=\"post\" action=\"product.html\"><button type=\"submit\">Try Again</button></form>");
		}
		else
		{
			HttpSession ses = request.getSession();
			ses.setAttribute("id", request.getParameter("id"));
			ses.setAttribute("name", request.getParameter("name"));
			ses.setAttribute("description", request.getParameter("description"));
			response.sendRedirect("ValidProduct.jsp");
			
		}
	}
	
	//Makes sure the id is a valid one
	private static boolean validID(String idTest)
	{
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(idTest);
		
		if(idTest.length() > 8)
			return false;
		else if (matcher.matches())
			return true;
		else
			return false;
	}

}