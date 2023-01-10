package BackEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String name=request.getParameter("name");  
	        String password=request.getParameter("password");
	        
	        
	        Admin a= new Admin();
	        a.setName(name);
	        a.setPassword(password);
	        
	  
	       boolean status=AdminDao.valid(a);  
	        if(status=true){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("Login.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          out.close();
	       
	       
	}

}
