package BackEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          EmpDao d= new EmpDao();
	          System.out.println(name+password);
	          if(d.valid(name, password))
	          {
	        	  request.getRequestDispatcher("index.html").forward(request, response); 
	          }else
	          {
	        	  out.println("Sorry! unable to save record"); 
	          }
	         
	        out.close();  
	    }  
	 
	}


